package com.example.jiandao.home.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseLazyFragment;
import com.example.jiandao.special.SpecialBean;
import com.example.jiandao.special.SpecialContract;
import com.example.jiandao.special.SpecialFragmentPresenter;
import com.example.jiandao.special.SpecialRvAdapter;

public class SpecialFragment extends BaseLazyFragment<SpecialFragmentPresenter> implements SpecialContract.ISpecialFragmentView {

    private RecyclerView rvSpecial;
    private SpecialRvAdapter adapter;

    @Override
    protected SpecialFragmentPresenter initPresenter() {
        return new SpecialFragmentPresenter();
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_special;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        rvSpecial = view.findViewById(R.id.rv_special);
    }

    @Override
    protected void initData() {
        mPresenter.getSpecialList();
    }

    @Override
    public void isCurrentVisibleToUser(boolean isVisible) {
        //当前Framgnet是显示还是隐藏
        if (adapter !=null) adapter.isCurrentVisibleToUser(isVisible);
    }

    @Override
    public void setSpecialList(SpecialBean specialBean) {
//        rvSpecial.setLayoutManager(new LinearLayoutManager(getActivity()));
//        rvSpecial.addItemDecoration(new DividerItemDecoration(getContext(), OrientationHelper.VERTICAL));
//        adapter = new SpecialRvAdapter(specialBean, getActivity());
//        rvSpecial.setAdapter(adapter);

        /*adapter.setOnItemClick(new SpecialRvAdapter.OnItemClick() {
            @Override
            public void onClick(int position) {
                SpecialBean.DataBean.ListBean listBean = specialBean.getData().getList().get(position);
                String id = listBean.getId();
                String link = listBean.getLink();
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("link",link);
                startActivity(intent);
            }
        });*/
    }
}
