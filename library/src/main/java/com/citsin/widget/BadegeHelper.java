/**
 * Copyright [2018] [citsin]
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * istributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.citsin.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class BadegeHelper {
  private int mBadegeColor;
  private float mBadegeSize;
  private final Paint mPaint;
  private boolean isShowNumber;
  private int number;
  private View mContentView;
  private float numberTextSize;
  private int numberTextColor;
  private boolean showBadege = false;
  private float badegeMarginTop;
  private float badegeMarginRight;
  private boolean badegeUsePadding = true;

  public BadegeHelper(View view) {
    this.mPaint = new Paint();
    this.isShowNumber = false;
    this.mBadegeColor = Color.BLUE;
    this.mBadegeSize = 16;
    this.mContentView = view;
    this.numberTextSize = 12;
    this.numberTextColor = Color.WHITE;
  }


  /**
   * Set the badege color
   * @param color
   */
  public void setBadegeColor(int color){
    this.mBadegeColor = color;
  }

  /**
   * Set badege size
   * Normaly it is the badege height
   * @param size
   */
  public void setBadegeSize(float size){
    this.mBadegeSize = size;
  }

  /**
   * Set whether to display number
   * @param enabled
   */
  public void setShowNumber(boolean enabled){
    this.isShowNumber = enabled;
  }
  /**
   * Set the display number
   * @param number
   */
  public void setNumber(int number){
    this.number = number;
  }

  /**
   * Set the size of display number
   * @param size
   */
  public void setNumberTextSize(float size){
    this.numberTextSize = size;
  }

  /**
   * Set the color of display number
   * @param color
   */
  public void setNumberTextColor(int color){
    this.numberTextColor = color;
  }

  /**
   * Set whether to display badege
   * @param show
   */
  public void setShowBadege(boolean show){
    this.showBadege = show;
  }

  public void draw(Canvas canvas){
    if (!showBadege)return;
    int width = mContentView.getWidth();
    int pt = mContentView.getPaddingTop();
    int pr = mContentView.getPaddingRight();
    if (!badegeUsePadding){
      pt = pr = 0;
    }
    if (isShowNumber){
      //measure text size
      String text = Integer.toString(number);
      mPaint.setTextSize(numberTextSize);
      float tw = mPaint.measureText(text);
      //draw badege background
      float radius = mBadegeSize/2;
      RectF rf = new RectF();
      rf.right = width-pr- badegeMarginRight;
      rf.top = pt+ badegeMarginTop;
      rf.left = rf.right-radius-radius-tw;
      rf.bottom = rf.top+mBadegeSize;

      mPaint.setColor(mBadegeColor);
      canvas.drawRoundRect(rf,radius,radius,mPaint);
      mPaint.setColor(numberTextColor);
      Paint.FontMetrics metrics = mPaint.getFontMetrics();
      canvas.drawText(text,
          rf.right-radius-tw,
          rf.top+radius - metrics.descent + (metrics.bottom - metrics.top) / 2,
          mPaint);
    }else {
      //Not display number
      float radius = mBadegeSize/2;
      float cx = width-pr-radius- badegeMarginRight;
      float cy = pt+radius+ badegeMarginTop;
      mPaint.setColor(mBadegeColor);
      canvas.drawCircle(cx,cy,radius,mPaint);
    }
  }

  /**
   *
   * @param badegeMarginTop
   */
  public void setBadegeMarginTop(float badegeMarginTop) {
    this.badegeMarginTop = badegeMarginTop;
  }

  /**
   *
   * @param badegeMarginRight
   */
  public void setBadegeMarginRight(float badegeMarginRight) {
    this.badegeMarginRight = badegeMarginRight;
  }

  /**
   * Set whether the badge is affected by view padding
   * @param usePadding
   */
  public void setBadegeUsePadding(boolean usePadding) {
    this.badegeUsePadding = usePadding;
  }

}
