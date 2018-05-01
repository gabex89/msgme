package com.smoothspark.msgme.ui.main;

import com.smoothspark.msgme.data.DataManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by SmoothSpark on 2018. 05. 01.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPagePresenterTest {

    @Mock
    MainPageMvpView mockMainPageMvpView;

    @Mock
    DataManager mockDataManager;

    private MainPagePresenter<MainPageMvpView> mainPagePresenter;

    @Before
    public void setUp() {
        mainPagePresenter = new MainPagePresenter<>(mockDataManager);
        mainPagePresenter.onAttach(mockMainPageMvpView);
    }

    @Ignore
    @Test
    public void testSuccessSendAndReceiveMessage() {
        //given
        String message = "TEST_MSG";

        //when


        //then
        verify(mockMainPageMvpView).updateMessagesList(message);

    }

    @After
    public void tearDown() throws Exception {
        mainPagePresenter.onDetach();
    }
}