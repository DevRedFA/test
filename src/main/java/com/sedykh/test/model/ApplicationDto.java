package com.sedykh.test.model;

import java.sql.Timestamp;
import lombok.Builder;
import lombok.Data;

@Data
// FIXME: 3/15/2018 remove after normal working mapper
@Builder
public class ApplicationDto {

  private String productName;

  private long id;

  private long contactId;

  // FIXME: 3/15/2018 find newer version of this
  private Timestamp dateTimeCreated;
}
