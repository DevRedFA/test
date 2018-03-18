package com.sedykh.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
// FIXME: 3/15/2018 remove after normal working mapper
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    private long id;

    private String productName;

    private long contactId;

    // FIXME: 3/15/2018 find newer version of this
    private Timestamp dateTimeCreated;
}
