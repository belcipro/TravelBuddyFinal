
package com.continental.travelbuddy.retrofit.respuesta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RespuestaLogin implements Serializable {
    private String ID_Usuario;
    private String US_Email;
    private String status;

    public String getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(String ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getUS_Email() {
        return US_Email;
    }

    public void setUS_Email(String US_Email) {
        this.US_Email = US_Email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}