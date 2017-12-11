package com.ztev.springlayout.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ${xiaozb} on 2017/12/11.
 *
 * @copyright by ztev
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String text;

    @Version
    private Calendar created = Calendar.getInstance();

    public Task(String title, String text, String date) {
        this.title = title;
        this.text = text;
        this.dueTo = toCalendar(date);
    }

    private Calendar toCalendar(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        try {
            Date date = sdf.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            return null;
        }
    }

    public Calendar getDueTo() {
        return dueTo;
    }

    public void setDueTo(Calendar dueTo) {
        this.dueTo = dueTo;
    }

    private Calendar dueTo;
}
