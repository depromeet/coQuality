package com.depromeet.coquality.outer.image.adapter.driving.web;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainExceptionCode;
import com.depromeet.coquality.outer.common.vo.ApiResponse;
import com.depromeet.coquality.outer.image.adapter.driving.web.response.ImageUploadResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<ImageUploadResponse> uploadImage(@RequestParam MultipartFile image) {
        final var imageFile = convert(image).orElseThrow(
            CoQualityDomainExceptionCode.IMAGE_IS_NULL::newInstance);

        final var url = upload(imageFile);
        final var response = new ImageUploadResponse(url, imageFile.getName());
        
        return ApiResponse.success(response);
    }

    private String upload(File uploadFile) {
        final var fileName = String.format("images/%s", UUID.randomUUID());

        amazonS3Client.putObject(
            new PutObjectRequest(bucket, fileName, uploadFile)
                .withCannedAcl(CannedAccessControlList.PublicRead)
        );

        return amazonS3Client.getUrl(bucket, fileName).toString();

    }

    private Optional<File> convert(MultipartFile file) {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (Exception e) {
            throw CoQualityDomainExceptionCode.IMAGE.newInstance(e.getCause(),
                e.getMessage());
        }
        return Optional.of(convertedFile);
    }

}
