/**
 * Copyright [2018] [citsin]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class BadegeImageView extends AppCompatImageView {

  private final BadegeHelper mHelper;


  public BadegeImageView(Context context) {
    this(context, null);
  }

  public BadegeImageView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public BadegeImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    mHelper = new BadegeHelper(this);
    TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BadegeImageView);
    mHelper.setShowBadege(a.getBoolean(R.styleable.BadegeImageView_showBadege, false));
    mHelper.setNumber(a.getInt(R.styleable.BadegeImageView_number, 0));
    float density = context.getResources().getDisplayMetrics().density;
    mHelper.setBadegeSize(a.getDimension(R.styleable.BadegeImageView_badegeSize, density * 16));
    mHelper.setNumberTextSize(a.getDimension(R.styleable.BadegeImageView_numberTextSize,
        density * 12));
    mHelper
        .setNumberTextColor(a.getColor(R.styleable.BadegeImageView_numberTextColor, Color.WHITE));
    mHelper.setBadegeColor(a.getColor(R.styleable.BadegeImageView_badegeColor, Color.RED));
    mHelper.setShowNumber(a.getBoolean(R.styleable.BadegeImageView_showNumber, false));
    mHelper.setBadegeMarginTop(a.getDimension(R.styleable.BadegeImageView_badegeMarginTop, 0));
    mHelper.setBadegeMarginRight(a.getDimension(R.styleable.BadegeImageView_badegeMarginRight, 0));
    mHelper.setBadegeUsePadding(a.getBoolean(R.styleable.BadegeImageView_badegeUsePadding, true));
    a.recycle();

  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    mHelper.draw(canvas);
  }

  public void setBadegeColor(int color) {
    this.mHelper.setBadegeColor(color);
  }

  public void setBadegeSize(int size) {
    this.mHelper.setBadegeSize(size);
  }

  public void setShowNumber(boolean enabled) {
    this.mHelper.setShowNumber(enabled);
  }

  public void setNumber(int number) {
    this.mHelper.setNumber(number);
  }

  public void setNumberTextSize(int size) {
    this.mHelper.setNumberTextSize(size);
  }

  public void setShowBadege(boolean show) {
    this.mHelper.setShowBadege(show);
  }


}
