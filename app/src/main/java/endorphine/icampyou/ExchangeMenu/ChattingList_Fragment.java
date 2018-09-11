package endorphine.icampyou.ExchangeMenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import endorphine.icampyou.BaseFragment;
import endorphine.icampyou.R;

public class ChattingList_Fragment extends BaseFragment {

    private EditText editSearch;

    final int save_info = 1;

    ListView listView = null;
    ChatList_Adapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_chattinglist,container,false);

        // 탭 호스트에 탭 추가
        TabHost tabHost1 = (TabHost)view.findViewById(R.id.tapHost_chatlist);
        tabHost1.setup();

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1");
        ts1.setContent(R.id.content1_chatlist);
        ts1.setIndicator("캠핑장 채팅");
        tabHost1.addTab(ts1);

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2");
        ts2.setContent(R.id.content2_chatlist);
        ts2.setIndicator("나의 채팅");
        tabHost1.addTab(ts2);

        Button add_chatlist_btn = (Button) view.findViewById(R.id.make_chatlist_button);
        add_chatlist_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getActivity(),Chat_Content.class);
                startActivityForResult(intent,save_info);
            }
        });

        adapter = new ChatList_Adapter(getActivity());

        //listView = (ListView) view.findViewById(R.id.camp_chat_listview);

        adapter.add(null,"전세영","냥냥","냥냥");

        //listView.setAdapter(adapter);


//        //채팅방 들어가기
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view ,int position,long id){
//                startFragment(getFragmentManager(),ChattingMessage_Fragment.class);
//            }
//        });
//
//        //채팅 목록 삭제
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long arg3) {
//
//                DialogInterface.OnClickListener positiveListener = new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        adapter.remove(position);
//                        listView.setAdapter(adapter);
//                    }
//                };
//
//                DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                };
//
//                new AlertDialog.Builder(getActivity())
//                        .setTitle("채팅 목록을 삭제하시겠습니까?")
//                        .setPositiveButton("예",positiveListener)
//                        .setNegativeButton("취소",cancelListener).show();
//
//                return true;
//            }
//        });

        editSearch = (EditText)view.findViewById(R.id.search);
        editSearch.addTextChangedListener(new TextWatcher(){

            @Override
            public void afterTextChanged(Editable edit) {
                //String text = editSearch.getText().toString().toLowerCase(Locale.getDefault());
                //adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {

            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        String pass_user = data.getStringExtra("user");
        String pass_need =data.getStringExtra("need");
        String pass_lettable = data.getStringExtra("lettable");
        byte[] image_byte = data.getByteArrayExtra("image");
        Bitmap pass_image = BitmapFactory.decodeByteArray(image_byte,0,image_byte.length);
        adapter.add(pass_image,pass_user,pass_need,pass_lettable);
        listView.setAdapter(adapter);
    }
}
