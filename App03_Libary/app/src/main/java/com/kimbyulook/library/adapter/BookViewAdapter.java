package com.kimbyulook.library.adapter;
/*
RecylerView에 데이터를 보여주기 위한 Helper Class
 */


import static com.squareup.picasso.Picasso.*;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kimbyulook.library.R;
import com.kimbyulook.library.model.NaverBookDTO;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookViewAdapter extends RecyclerView.Adapter {

    private List<NaverBookDTO> bookList;

    /**
     * RecylerView에서 사용할 데이터(bookList)를 어떻게 외부에서 Adapter에 보낼것인가
     * 생성자, setter()를 사용하여 주입한다.
     *
     *
     * RecyclerView 의 Adapter를 객체로 생성할때
     *
     * 화면에 보여줄 데이터를 전달하자(주입하자)
     *
     *
     * 데이터를 매개변수가 갖는 생성자를 만든다
     *
     */

    public BookViewAdapter(List<NaverBookDTO> bookList){
        this.bookList = bookList;
    }


    @NonNull
    @Override
    /**
     * onCreateViewHolder
     * item을 그리는 item.xml파일을 읽어서 사용할 준비를 하기
     * item.xml file을 view로 생성하고 데이터와 연결할 준비
     */
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        inflater(확장, 펼치기)
        //*.xml 파일에 설정돤 view정보를 읽어서 JavaCode에서 사용하기 위한 객체로 생성하는것


        // item.xml 파일을 읽어와서 Holder 로 만들기 전에 확장하기 위한 도구
        LayoutInflater layoutInflater =
        LayoutInflater.from(parent.getContext());
//      book_item_view.xml내용이 view객체로 변환되었다.
        View view = layoutInflater.inflate(R.layout.book_item_view,
                parent,
                false);


        //생성된 view객체를 BookViewHolder 클래스의 생성자에 주입하면서
        // ViewHolder 객체를 생성하기
        BookItemHolder viewHolder = new BookItemHolder(view);

//        생성된 viewHolder 객체를 RecyclerView에게 return 하기


       return viewHolder;





    }

    @Override
    /**
     * 생성된 Holder와 실제 데이터 (한개의 데이터)를 연결하는 작업
     * 한개의 데이터를 연결하는 작업을 수행하지만
     * RecyclerView에 의해서 데이터들의 갯수만큼 반복적으로 호출되어 화면에 데이터를 그리는 작업을 수행
     * RecyclerView onBindViewHolder() method 를 호출하면서
     * 몇번째 데이터를 Binding 할 것 인지에 대한 Index로 positon 변수에
     * 값을 전달해 준다
     *
     */
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        /**
         *
         * 매개 변수로 받은 holder를 우리가 선언한 BookItemHolder로 형변환을 시키고 이후 코드를 진행한다
         */

        BookItemHolder bookItemHolder= (BookItemHolder) holder;
//        전체 데이터에서 그리고자하는 데이터(한개)를 추출한다
//        이때 매개변수로 전달받은 position을 사용하여 데이터를 getter한다

        NaverBookDTO bookDTO = bookList.get(position);

        String item_title = bookDTO.getTitle();
        Spanned sp_title = Html.fromHtml(item_title,Html.FROM_HTML_MODE_LEGACY);
        bookItemHolder.item_title.setText(sp_title);


        String item_desc = bookDTO.getDescription();
        Spanned sp_desc = Html.fromHtml(item_desc,Html.FROM_HTML_MODE_LEGACY);
        bookItemHolder.item_desc.setText(sp_desc);
//        bookItemHolder.item_desc.setText(bookDTO.getDescription());

        /**
         * naverAPI를 통해서 전달받은 데이터중 image 정보 표시하기
         * naver API에서는 도서에 대한 image를 이미지 주소(link)문자열로 보낸다
         *
         * HTML에서는 단순히 img src = "" 코드를 사용하여 연결하면
         * 자동으로 다운로드를 받으면서 이미지를 보여준다
         *
         * 하지만 안드로이드에서는 디바이스 자체가 성능이 낮기때문에
         * 직접 이미지를 다운로드하거나 하면 문자를 일으킬 수 있다.
         * 안드로이드 에서 이미지 링크를 실제 이미지로 보여주는데
         * picasso , Glide 같은 3rd party 라이브러리를 사용하여
         * 화면에 이미지를 구현한다
         *
         *           picasso              Glide
         * 속도    면에서 다소느림            속도면에서 다소빠름
         * 메모리      적게소모                많이 소모
         * 기능       단순무식              다양한 기능 존재
         */
        if(!bookDTO.getImage().isEmpty()){
            Picasso.get()
                    .load(bookDTO.getImage())
                    .into(bookItemHolder.item_image);

        }
    }

    @Override
    /**
     * onCreateViewHolder에서 생성된 holder를 사용하여 OnBindViewHolder가 데이터 한개를 그리기를 수행하면
     * RecyclerView 에게 지금 데이터가 몇개 인지 알려주고 데이터 갯수만큼 반복적으로 Holder를 그려라 는 값을 알려주는 메서드
     *
     */
    public int getItemCount() {

        return bookList == null ? 0 : bookList.size();
    }

    /**
     * onCreateViewHolder() method 가 사용하는 클래스
     * 실제 item.xml에 작성된 각각의 view componet를 실제적으로 사용할수 있도록 각각 개별 객체
     * (view 객체)로 생성하기 위한 보조 class
     * <p>
     * 초기에 RecyclerView인 ListView시절에는 선택사항으로 만들지않아도 되었었는데
     * RecylerVeiw에서는 반드시 있어야하는 필수클래스이다
     *
     * 우리가 작성할 코드는
     * item.xml 에 설정된 view Component 개별요소를 추출하여 각각 객체로 만드는일
     *
     * book_view_item.xml에는 TextView가 있다
     *
     * 이 Textview를 사용할 수 있도록 객체로 만드는 일
     */
    public static class BookItemHolder extends RecyclerView.ViewHolder {
        public ImageView item_image;

        public TextView item_title;
        public TextView item_desc;


        public BookItemHolder(@NonNull View itemView) {
            super(itemView);
                item_title = itemView.findViewById(R.id.book_item_title);
                item_desc = itemView.findViewById(R.id.book_item_desc);
                item_image = itemView.findViewById(R.id.book_item_image);
        }

    }

}
