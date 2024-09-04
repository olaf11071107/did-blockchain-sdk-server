/*
 * Copyright 2024 Raonsecure
 */

package org.omnione.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.omnione.did.data.model.util.json.GsonWrapper;

/**
 * The {@code FabricResponse} class represents a response from a Fabric network operation.
 * It encapsulates the status, message, and payload returned by the operation.
 */
@Getter
@Setter
@NoArgsConstructor
public class FabricResponse {

  @Expose
  @SerializedName("status")
  private int status;

  @Expose
  @SerializedName("message")
  private String message;

  @Expose
  @SerializedName("payload")
  private String payload;

  /**
   * Populates the fields of this {@code FabricResponse} instance by deserializing the provided JSON string.
   *
   * <p>This method uses a custom Gson wrapper to convert the JSON string into a {@code FabricResponse} object,
   * and then copies the data into the current instance.</p>
   *
   * @param val the JSON string representing a {@code FabricResponse} object
   */
  public void fromJson(String val) {
    GsonWrapper gson = new GsonWrapper();
    FabricResponse data = gson.fromJson(val, FabricResponse.class);
    status = data.status;
    message = data.message;
    payload = data.payload;
  }
}
