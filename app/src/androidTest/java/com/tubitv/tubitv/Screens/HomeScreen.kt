package com.tubitv.tubitv.Screens

import android.support.test.uiautomator.UiCollection
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiObject
import android.support.test.uiautomator.UiSelector
import com.tubitv.tubitv.globalTimeout
import com.tubitv.tubitv.moviesListTimeout
import junit.framework.Assert
import java.lang.reflect.AccessibleObject

/**
 * Created by vburian on 2/19/18.
 */
open class HomeScreen:BaseScreen(){
    protected val firstListOfAllObjects = UiCollection(UiSelector().resourceId("com.tubitv:id/view_category_recycler"))
    private val categoryList = UiSelector().resourceId("com.tubitv:id/view_content_recycler_ll")
    private val textOfMovie = UiSelector().resourceId("com.tubitv:id/view_home_content_title_tv")
    private val titleOfMovie =    UiSelector().resourceId("com.tubitv:id/view_home_content_iv")
    private val textOFCategory =UiSelector().resourceId("com.tubitv:id/view_content_recycler_category_title")



    init{
        Assert.assertTrue("Expected first List of All Objects is not displayed",firstListOfAllObjects.waitForExists(moviesListTimeout))
        Assert.assertTrue("Expected titles is not displayed",getTitleFromGrid().waitForExists(moviesListTimeout))
    }
    protected fun getGrid(number:Int) =
            firstListOfAllObjects.getChildByInstance(categoryList,number) // it's object of all category moivies in homepage

    private fun getTextOFMovie() =
            getGrid(1).getChild(textOfMovie) //got a first element from the list of movies

    private fun getTitleFromGrid()=
            getGrid(1).getChild(titleOfMovie)

    public   fun getTextOfCategory()=
            getGrid(1).getChild(textOFCategory)




    private fun waitforexist(){

        val f=getTextOfCategory()
    }

   //private fun som(){


      // uiDevice.findObject(textOFCategory.text("fd")).waitForExists("fdf") CHECK THIS OUT
  // }

    public val textCategory=getTextOfCategory().text

    public val title get() = getTextOFMovie().text //get text title form the home page

    public fun clickOnTitleNoGotIt():MovieDatailScreen{
        getTextOFMovie().click()
        return MovieDatailScreen()
    }


    public fun clickOnTitle():GotIt{
        getTextOFMovie().click()
        return GotIt()
    }
    public fun clickBack(){
        val pressBack = uiDevice.pressBack()
    }

    public fun longPress():AddToQueue{
        getTitleFromGrid().dragTo(getTitleFromGrid(),10)

return AddToQueue()
    }

    public fun longPressToRemoveFromQueue():AddToQueue{
        getTitleFromGrid().dragTo(getTitleFromGrid(),10)


        return AddToQueue()
    }


   open class HomeScreenWithContinueWatching():BaseScreen(){
       private val titleInContinueWatching = uiDevice.findObject(UiSelector().resourceId("com.tubitv:id/view_home_content_continue_iv"))

        init{
            Assert.assertTrue("Title is not added to 'History' after watcing 30 sec and click Back",titleInContinueWatching.waitForExists(moviesListTimeout))
        }
        public fun removeFromHistory(){
            titleInContinueWatching.dragTo(titleInContinueWatching,10)
            uiDevice.findObject(UiSelector().resourceId("android:id/select_dialog_listview")).waitForExists(globalTimeout)
        }
    }



    class RemoveFormHistoryScreen():BaseScreen(){
        private val boxWithRemoveFromHistory = UiCollection(UiSelector().resourceId("android:id/select_dialog_listview"))
        private val removeFromHistory=UiSelector().resourceId("android:id/text1")
        init{
            Assert.assertTrue("Title is not added to 'History' after watcing 30 sec and click Back",boxWithRemoveFromHistory.waitForExists(moviesListTimeout))
        }
        protected fun getBottonRemoveFromHistory()=
            boxWithRemoveFromHistory.getChildByInstance(removeFromHistory,0)


        public fun clickOnRemoveFromHistory(){
            getBottonRemoveFromHistory().click()


        }

    }


    class QueueScreen(){
        var homescreen=HomeScreen()
        private val queueList=UiSelector().resourceId("com.tubitv:id/view_content_recycler_ll")
        private val titlesInQueue=UiSelector().resourceId("com.tubitv:id/view_home_content_iv")
       init{Assert.assertTrue("Expected queue is not displayed",getQueuFromGrid().waitForExists(globalTimeout))}
        protected fun getGrid(number:Int) =
                homescreen.firstListOfAllObjects.getChildByInstance(queueList,number) // it's object of all category moivies in

        private fun getQueuFromGrid()=
                getGrid(1).getChild(homescreen.textOfMovie)


        public val textFromFirstTitleInQueue get()=getQueuFromGrid().text



    }







     class AddToQueue():BaseScreen(){
         private val addToQueueLongClick=uiDevice.findObject(UiSelector().resourceId("android:id/text1"))
     init{
         Assert.assertTrue("Expected small window with add to queue is not displayed",addToQueueLongClick.waitForExists(moviesListTimeout))

     }

         public fun clickAddToQueueAfterLongClick():QueueScreen{
             addToQueueLongClick.click()
             return QueueScreen()
         }
     }

    }


