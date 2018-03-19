package com.sedykh.test.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {

  @JsonProperty("PRODUCT_NAME")
  private String productName;

  @JsonProperty("APPLICATION_ID")
  private long id;

  @JsonProperty("CONTACT_ID")
  private long contactId;

  @JsonProperty("DT_CREATED")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm z")
  private Timestamp dateTimeCreated;
}
