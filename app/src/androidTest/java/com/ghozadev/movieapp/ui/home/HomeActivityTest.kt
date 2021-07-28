package com.ghozadev.movieapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.utils.DataDummy
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test


class HomeActivityTest {
    private val dummyFilm = DataDummy.generateDummyMovies()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadFilms() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyFilm.size))
    }

    @Test
    fun loadDetailFilm() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyFilm[0].title)))
        onView(withId(R.id.text_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_release_date)).check(matches(withText(dummyFilm[0].releaseDate)))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(dummyFilm[0].description)))
    }

}