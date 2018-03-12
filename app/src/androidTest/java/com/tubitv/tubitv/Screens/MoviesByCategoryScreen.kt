package com.tubitv.tubitv.Screens

import android.support.test.uiautomator.UiSelector
import com.tubitv.tubitv.globalTimeout
import junit.framework.Assert

/**
 * Created by vburian on 2/23/18.
 */
class MoviesByCategoryScreen:BaseScreen(){
    private val categoryName= uiDevice.findObject(UiSelector().resourceId("com.tubitv:id/nav_app_bar_main_title"))
    private val title =uiDevice.findObject( UiSelector().resourceId("com.tubitv:id/view_category_content_iv"))
    private val textOfTitle= uiDevice.findObject(UiSelector().resourceId("com.tubitv:id/view_category_content_tv_title"))
    public val categoryText get() = categoryName.text
    public val  titleText get()=textOfTitle.text

init{

    Assert.assertTrue("Expected Category name in TOP is not displayed",categoryName.waitForExists(globalTimeout))

}

    public fun clickOnTitle():GotIt{
        title.click()
        return GotIt()
    }
}