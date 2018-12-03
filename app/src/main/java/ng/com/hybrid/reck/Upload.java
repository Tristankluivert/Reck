package ng.com.hybrid.reck;

import com.google.firebase.storage.StorageMetadata;

public class Upload {

    private String mName,mService,mLocation,mPrice;
    private String mImageUrl;

    public Upload(String trim, StorageMetadata metadata) {
        //empty constructor needed
    }

    public String getmService() {
        return mService;
    }

    public void setmService(String mService) {
        this.mService = mService;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public Upload(String name, String loca, String ser, String price, String imageUrl) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        if(ser.trim().equals("")) {
            ser = "No Service";
        }

        if(loca.trim().equals("")) {
            loca = "No Location";
        }

        if(price.trim().equals("")) {
            price = "No Price";
        }

        mLocation = loca;
        mService = ser;
        mLocation = price;
        mName = name;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
