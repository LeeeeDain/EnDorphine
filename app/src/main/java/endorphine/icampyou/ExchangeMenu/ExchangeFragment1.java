package endorphine.icampyou.ExchangeMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import endorphine.icampyou.BaseFragment;
import endorphine.icampyou.R;

/**
 * 교환 프래그먼트1 클래스
 */
public class ExchangeFragment1 extends BaseFragment {
    private View view;

    // 프래그먼트 xml 설정하는 메소드
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 먼저 view에 xml 설정
        view = inflater.inflate(R.layout.fragment_exchange_1, container, false);
        return view;
    }
}
