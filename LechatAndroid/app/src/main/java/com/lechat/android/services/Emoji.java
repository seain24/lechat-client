package com.lechat.android.services;

import com.lechat.android.R;

/**
 * @Author: Seain
 * @Date: on 2024-10-20 19:48.
 * @Description: 表情包类
 */
public class Emoji {
    public static final int DEFAULT_NULL_FACEID = -1;
    private int             id;
    private String          faceid;
    private String          tip;
    private String          file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaceid() {
        return faceid;
    }

    public void setFaceid(String faceid) {
        this.faceid = faceid;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    static int stringToResID(String source){
        String faceID = source.substring(4);
        int id = Integer.parseInt(faceID);
        if (id == 0)
            return R.drawable.face0;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 2)
            return R.drawable.face2;
        else if (id == 3)
            return R.drawable.face3;
        else if (id == 4)
            return R.drawable.face4;
        else if (id == 5)
            return R.drawable.face5;
        else if (id == 6)
            return R.drawable.face6;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;
        else if (id == 1)
            return R.drawable.face1;

        return R.drawable.face0;
    }
}
