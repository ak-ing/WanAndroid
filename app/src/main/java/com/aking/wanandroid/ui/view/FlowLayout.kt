package com.aking.wanandroid.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.children
import com.aking.wanandroid.R
import com.aking.wanandroid.util.dp

/**
 * Created by AK on 2022/8/20 23:01.
 * God bless my code!
 */
class FlowLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    private val mLines = mutableListOf<MutableList<View>>()
    private val mList = mutableListOf<String>()
    private val layoutInflater by lazy { LayoutInflater.from(context) }
    private var itemClickListener: ((String) -> Unit)? = null

    private var mHorizontalMargin = 0f
    private var mVerticalMargin = 0f
    private var mMaxLines = 4

    private var mMeasureChildHeight = 0

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout)
        mHorizontalMargin = a.getDimension(R.styleable.FlowLayout_horizontalMargin, 8.dp)
        mVerticalMargin = a.getDimension(R.styleable.FlowLayout_verticalMargin, 8.dp)
        mMaxLines = a.getInt(R.styleable.FlowLayout_maxLines, mMaxLines)
        a.recycle()
    }

    /**
     * 设置数据
     */
    fun setList(texts: List<String>) {
        mList.clear()
        mList.addAll(texts)
        setUpChildren()
    }

    /**
     * 设置子view
     */
    private fun setUpChildren() {
        removeAllViews()
        for (s in mList) {
            val child = layoutInflater.inflate(R.layout.item_text_flowlayout, this, false)
            child.setOnClickListener { itemClickListener?.invoke(s) }
            if (child is TextView) {
                child.text = s
            }
            addView(child)
        }
    }

    fun setItemClickListener(clickListener: (String) -> Unit) {
        itemClickListener = clickListener
    }

    private fun checkChildCanBeAdd(line: List<View>, child: View, parentWidthSize: Int): Boolean {
        if (line.isEmpty()) return true
        val measuredWidth = child.measuredWidth
        var totalWidth = mHorizontalMargin + paddingLeft
        for (view in line) {
            totalWidth += view.measuredWidth + mHorizontalMargin
        }
        totalWidth += measuredWidth + mHorizontalMargin + paddingRight
        //如果超出限制宽度，则不可以再添加
        //否则可以添加
        return totalWidth <= parentWidthSize
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val parentWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        val parentHeightSize = MeasureSpec.getSize(heightMeasureSpec)
        val measureSpec = MeasureSpec.makeMeasureSpec(parentHeightSize, MeasureSpec.UNSPECIFIED)
        super.onMeasure(widthMeasureSpec, measureSpec)

        val count = childCount
        if (count == 0) {
            return
        }

        //先清空
        mLines.clear()
        var line = mutableListOf<View>()
        //添加默认行
        mLines.add(line)
        val childWidthSpec = MeasureSpec.makeMeasureSpec(parentWidthSize, MeasureSpec.AT_MOST)
        val childHeightSpec = MeasureSpec.makeMeasureSpec(parentHeightSize, MeasureSpec.AT_MOST)

        for (child in children) {
            measureChild(child, childWidthSpec, childHeightSpec)
            //判断是否可以添加到当前行
            val canBeAdd = checkChildCanBeAdd(line, child, parentWidthSize)
            if (!canBeAdd) {
                if (mLines.size >= mMaxLines) {
                    break
                }
                line = arrayListOf()
                mLines.add(line)
            }
            line.add(child)
        }
        mMeasureChildHeight = getChildAt(0).measuredHeight

        //根据尺寸计算所有行高
        val child = getChildAt(0)
        val childHeight = child.measuredHeight
        val parentHeightTargetSize =
            childHeight * mLines.size + (mLines.size + 1) * mVerticalMargin.toInt() + paddingTop + paddingBottom
        setMeasuredDimension(parentWidthSize, parentHeightTargetSize)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var currentLeft = mHorizontalMargin.toInt() + paddingLeft
        var currentTop = mVerticalMargin.toInt() + paddingTop
        var currentRight: Int
        var currentBottom = mMeasureChildHeight + currentTop
        for (line in mLines) {
            for (view in line) {
                //布局每一行
                val width = view.measuredWidth
                currentRight = currentLeft + width
                //判断最右边的边界
                if (currentRight > measuredWidth - mHorizontalMargin - paddingRight) {
                    currentRight = (measuredWidth - mHorizontalMargin - paddingRight).toInt()
                }
                view.layout(currentLeft, currentTop, currentRight, currentBottom)
                currentLeft = (currentRight + mHorizontalMargin).toInt()
            }
            currentLeft = mHorizontalMargin.toInt() + paddingLeft
            currentBottom += mMeasureChildHeight + mVerticalMargin.toInt()
            currentTop += mMeasureChildHeight + mVerticalMargin.toInt()
        }
    }
}