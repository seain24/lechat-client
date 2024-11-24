package com.lechat.android.pojo;

import com.lechat.android.utils.PictureUtil;

import java.io.Serializable;

/**
 * @Author: Seain
 * @Date: on 2024-10-20 17:51.
 * @Description: 用户登录信息
 */
public class MemberEntity implements Serializable {
    private String id = "0";
    private String strAccountNo;
    private String strAccountNo2;
    private String mobile;// 手机号
    private int uAccountID;
    private String password;
    private String uBirthday;//生日
    private String strCustomFace;//头像
    private String strSignature;//个性签名
    private String nickname;//昵称
    private int nFace;
    private String headPath;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStrAccountNo2() {
        return strAccountNo2;
    }

    public void setStrAccountNo2(String strAccountNo2) {
        this.strAccountNo2 = strAccountNo2;
    }

    public int getnFace() {
        return nFace;
    }

    public void setnFace(int nFace) {
        this.nFace = nFace;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStrSignature() {
        return strSignature;
    }

    public void setStrSignature(String strSignature) {
        this.strSignature = strSignature;
    }

    public String getuBirthday() {
        return uBirthday;
    }

    public void setuBirthday(String uBirthday) {
        this.uBirthday = uBirthday;
    }

    public String getStrCustomFace() {
        return strCustomFace;
    }

    public void setStrCustomFace(String strCustomFace) {
        this.strCustomFace = strCustomFace;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
        PictureUtil.SetHeadPath(uAccountID, headPath);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStrAccountNo() {
        return strAccountNo;
    }

    public void setStrAccountNo(String strAccountNo) {
        this.strAccountNo = strAccountNo;
    }

    public int getuAccountID() {
        return uAccountID;
    }

    public void setuAccountID(int uAccountID) {
        this.uAccountID = uAccountID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
