package com.sedykh.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    private long id;

    private String productName;

    private long contactId;

    private Timestamp dateTimeCreated;
}
