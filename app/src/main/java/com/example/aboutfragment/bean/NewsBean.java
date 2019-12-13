package com.example.aboutfragment.bean;

import java.io.Serializable;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/12 16:07
 */
public class NewsBean implements Serializable {

    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
