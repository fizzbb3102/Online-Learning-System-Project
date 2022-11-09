/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Zake
 */
public class SettingDetails {
    private int settingId;
    private int typeId;
    private String value;
    private String order;
    private String note;
    private boolean status;
    private LocalDateTime created_time;
    private LocalDateTime updated_time;

    public SettingDetails() {
    }

    public SettingDetails(int settingId, int typeId, String value, String order, String note, boolean status, LocalDateTime created_time, LocalDateTime updated_time) {
        this.settingId = settingId;
        this.typeId = typeId;
        this.value = value;
        this.order = order;
        this.note = note;
        this.status = status;
        this.created_time = created_time;
        this.updated_time = updated_time;
    }

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    public LocalDateTime getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(LocalDateTime updated_time) {
        this.updated_time = updated_time;
    }

    @Override
    public String toString() {
        return settingId + " - " + value + " - " + typeId;
    }
    
    
    
    
}
