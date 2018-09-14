package com.mapbox.mapboxsdk.plugins.annotation;

import android.support.test.runner.AndroidJUnit4;
import com.mapbox.mapboxsdk.plugins.testapp.activity.BuildingActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import timber.log.Timber;

import static com.mapbox.mapboxsdk.plugins.annotation.MapboxMapAction.invoke;
import static com.mapbox.mapboxsdk.style.layers.Property.CIRCLE_PITCH_ALIGNMENT_MAP;
import static com.mapbox.mapboxsdk.style.layers.Property.CIRCLE_PITCH_SCALE_MAP;
import static com.mapbox.mapboxsdk.style.layers.Property.CIRCLE_TRANSLATE_ANCHOR_MAP;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Basic smoke tests for CircleManager
 */
@RunWith(AndroidJUnit4.class)
public class CircleManagerTest extends BaseActivityTest {

  private CircleManager circleManager;

  @Override
  protected Class getActivityClass() {
    return BuildingActivity.class;
  }

  private void setupCircleManager() {
    Timber.i("Retrieving layer");
    invoke(mapboxMap, (uiController, mapboxMap) -> {
      circleManager = new CircleManager(mapboxMap);
    });
  }

  @Test
  public void testCircleTranslateAsConstant() {
    validateTestSetup();
    setupCircleManager();
    Timber.i("circle-translate");
    invoke(mapboxMap, (uiController, mapboxMap) -> {
      assertNotNull(circleManager);

      circleManager.setCircleTranslate(new Float[] {0f, 0f});
      assertEquals((Float[]) circleManager.getCircleTranslate(), (Float[]) new Float[] {0f, 0f});
    });
  }

  @Test
  public void testCircleTranslateAnchorAsConstant() {
    validateTestSetup();
    setupCircleManager();
    Timber.i("circle-translate-anchor");
    invoke(mapboxMap, (uiController, mapboxMap) -> {
      assertNotNull(circleManager);

      circleManager.setCircleTranslateAnchor(CIRCLE_TRANSLATE_ANCHOR_MAP);
      assertEquals((String) circleManager.getCircleTranslateAnchor(), (String) CIRCLE_TRANSLATE_ANCHOR_MAP);
    });
  }

  @Test
  public void testCirclePitchScaleAsConstant() {
    validateTestSetup();
    setupCircleManager();
    Timber.i("circle-pitch-scale");
    invoke(mapboxMap, (uiController, mapboxMap) -> {
      assertNotNull(circleManager);

      circleManager.setCirclePitchScale(CIRCLE_PITCH_SCALE_MAP);
      assertEquals((String) circleManager.getCirclePitchScale(), (String) CIRCLE_PITCH_SCALE_MAP);
    });
  }

  @Test
  public void testCirclePitchAlignmentAsConstant() {
    validateTestSetup();
    setupCircleManager();
    Timber.i("circle-pitch-alignment");
    invoke(mapboxMap, (uiController, mapboxMap) -> {
      assertNotNull(circleManager);

      circleManager.setCirclePitchAlignment(CIRCLE_PITCH_ALIGNMENT_MAP);
      assertEquals((String) circleManager.getCirclePitchAlignment(), (String) CIRCLE_PITCH_ALIGNMENT_MAP);
    });
  }
}