package com.razodeh.imagetotextbanner.utils;

import com.razodeh.imagetotextbanner.domain.BannerOptions;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

public class UploadValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BannerOptions.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BannerOptions options = (BannerOptions) target;
        MultipartFile multipartFile = options.getImage();
        if (multipartFile == null || multipartFile.isEmpty()) {
            errors.rejectValue("image", "required");
        }
    }
}
