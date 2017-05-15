// Enter your page ID here!
private string PAGE_ID = "page_id_here";

// Returns the URL for the facebook button
private String getFacebookPageURL() {
    String FACEBOOK_URL = "https://www.facebook.com/your_page";

    PackageManager packageManager = getPackageManager();
    try {
        int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;

        boolean activated = packageManager.getApplicationInfo("com.facebook.katana", 0).enabled;
        if (activated) {
            if ((versionCode >= 3002850)) {
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else {
                return "fb://page/" + PAGE_ID;
            }
        } else {
            return FACEBOOK_URL;
        }
    } catch (PackageManager.NameNotFoundException e) {
        return FACEBOOK_URL;
    }
}
