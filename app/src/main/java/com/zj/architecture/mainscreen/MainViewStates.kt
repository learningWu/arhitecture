package com.zj.architecture.mainscreen

import com.zj.architecture.repository.NewsItem
import com.zj.architecture.utils.FetchStatus

/**
 * 控制界面 UI 展示的 State
 */
data class MainViewState(
    /**
     * 加载状态
     */
    val fetchStatus: FetchStatus = FetchStatus.NotFetched,
    /**
     * 列表数据
     */
    val newsList: List<NewsItem> = emptyList()
)

/**
 * 触发 View 展示的 Event
 */
sealed class MainViewEvent {
    data class ShowSnackbar(val message: String) : MainViewEvent()
    data class ShowToast(val message: String) : MainViewEvent()
}

/**
 * 传递用户交互的 Action
 */
sealed class MainViewAction {
    data class NewsItemClicked(val newsItem: NewsItem) : MainViewAction()
    object FabClicked : MainViewAction()
    object OnSwipeRefresh : MainViewAction()
    object FetchNews : MainViewAction()
}