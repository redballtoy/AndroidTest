package com.example.redballtoy.resourcestest_gb;

public class AndroidVersionModelData {
    public String versionName;
    public int versionPicId;
    public String descriptionEn;
    public String descriptionRu;

    public AndroidVersionModelData(String versionName, int versionPicId) {
        this.versionName = versionName;
        this.versionPicId = versionPicId;
        this.descriptionRu = null;
        this.descriptionEn = null;
    }

    public AndroidVersionModelData(String versionName, int versionPicId, String descriptionEn, String descriptionRu) {
        this.versionName = versionName;
        this.versionPicId = versionPicId;
        this.descriptionEn = descriptionEn;
        this.descriptionRu = descriptionRu;
    }
}
