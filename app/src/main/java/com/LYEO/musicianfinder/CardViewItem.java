package com.LYEO.musicianfinder;

/**
 * Created by Lidor on 9/25/2020.
 * Website: www.buckystudents.com
 *  _        _   _____     ____    ______
 * | |      |_| |  __ \   / __ \  |  O   |
 * | |      | | | |  | | | |  | | |   ___/
 * | |____  | | | |__| | | |__| | | | \
 * |______| |_| |_____/   \____/  |_|__\
 *  ____         ____
 * |  __|       |  __|
 * |  __|   _   |__  |
 * |____|  |_|  |____|
 */
class CardViewItem {
    private int mImageResource, mColorResource;
    private String mName;
    private boolean isSelected = false;

    public CardViewItem(String text1, int imageResource, int colorResource) {
        mName = text1;
        mImageResource = imageResource;
        this.mColorResource = colorResource;
    }
    public int getImageResource() {
        return mImageResource;
    }
    public String getName() {
        return mName;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public int getmColorResource() {
        return mColorResource;
    }
    public void setmColorResource(int mColorResource) {
        this.mColorResource = mColorResource;
    }
}
