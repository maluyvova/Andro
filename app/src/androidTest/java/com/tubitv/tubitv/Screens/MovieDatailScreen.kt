package com.tubitv.tubitv.Screens

import android.os.Parcel
import android.os.Parcelable
import android.support.test.uiautomator.UiCollection
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import com.tubitv.tubitv.globalTimeout
import junit.framework.Assert

/**
 * Created by vburian on 2/20/18.
 */
class MovieDatailScreen() :BaseScreen(){

    private val titleText = uiDevice.findObject(UiSelector().resourceId("com.tubitv:id/textView_title"))
    private val addToQueue = uiDevice.findObject(UiSelector().resourceId("com.tubitv:id/imageView_add_from_queue"))
    private val youMightAlsoLike=uiDevice.findObject(UiSelector().resourceId("com.tubitv:id/view_content_recycler_category_title"))
    private val playButton=uiDevice.findObject(UiSelector().resourceId("com.tubitv:id/imageView_play"))


    init {
        Assert.assertTrue("Expected title text  is not displayed", titleText.waitForExists(globalTimeout))
        Assert.assertTrue("Expected button add to queue is not displayed", addToQueue.waitForExists(globalTimeout))
        //Assert.assertTrue("'You might also like' is not displayed", youMightAlsoLike.waitForExists(globalTimeout))
    }

    public val titleDatailScreen get() = titleText.text //get text from the datail page

    constructor(parcel: Parcel) : this() {
    }

    fun clickOnAddToQueue():HomeScreen {
        addToQueue.click()
            uiDevice.pressBack()
             return HomeScreen()
    }

    fun clickOnRemoveFromQueue():HomeScreen {
        addToQueue.click()
        return HomeScreen()
    }
    fun  simpleClickOnAddToQueue(){
        addToQueue.click()
    }
    fun simpleClickOnRemoveFromQueue():HomeScreen{
        addToQueue.click()
        uiDevice.pressBack()
        return HomeScreen()
    }
    fun clickOnPlay():PlayBackScreen{
        playButton.click()
        return PlayBackScreen()
    }


}



class GotIt():BaseScreen(){

    private val gotItButton=uiDevice.findObject(UiSelector().resourceId("com.tubitv:id/got_it_button"))

    init{ Assert.assertTrue("Expected button 'got it' on yellow beckground is not displayed", gotItButton.waitForExists(globalTimeout))

    }
    fun clickOnGotIt():MovieDatailScreen {
        gotItButton.click()
        return MovieDatailScreen()
    }

}









