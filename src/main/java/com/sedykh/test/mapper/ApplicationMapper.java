package com.sedykh.test.mapper;

import com.sedykh.test.dao.entity.ApplicationEntity;
import com.sedykh.test.model.Application;
import com.sedykh.test.model.ApplicationDto;
import org.modelmapper.ModelMapper;

public class ApplicationMapper {

    private ApplicationMapper() {
    }

    private static ModelMapper modelMapper = new ModelMapper();


    public static ApplicationDto toApplicationDto(Application application) {
        return modelMapper.map(application, ApplicationDto.class);
    }

    public static Application toApplication(ApplicationEntity applicationEntity) {
        Application application = modelMapper.map(applicationEntity, Application.class);
        application.setContactId(applicationEntity.getContract().getId());
        return application;
    }
// FIXME: 18.03.2018 remove it?
//    public static Application toApplication(ApplicationDto applicationDto) {
//        return modelMapper.map(applicationDto, Application.class);
//    }
//
//    public static ApplicationEntity toApplicationEntity(Application application) {
//        return modelMapper.map(application, ApplicationEntity.class);
//    }
}
