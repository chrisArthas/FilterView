# FilterView
Android 自定义 多层筛选框

![预览效果](https://github.com/chrisArthas/FilterView/raw/master/imge.png)

使用方法：

xml中
```
    <com.filterviewdemo.filterview.FilterView
        android:id="@+id/filter_view"
        android:layout_width="match_parent"
        android:layout_height="300dp">

    </com.filterviewdemo.filterview.FilterView>
      
      
      
```      
activity中
```
        filterView = (FilterView)findViewById(R.id.filter_view);

        initData();

        filterView.setData(dataList);
        filterView.setCallBackInterface(this);
        filterView.setFSelectPosition(0);
```
需要在initData（）方法中构造数据，也可以自己定义
