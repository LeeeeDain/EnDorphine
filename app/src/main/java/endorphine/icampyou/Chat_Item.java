package endorphine.icampyou;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class Chat_Item {
    private int need_pic_id;
    private Bitmap need_pic;
    private String user_id;
    private String need_thing;
    private String lettable_thing;

    public Chat_Item(String _user_id,String _need_thing,String _lettable_thing){
        this.user_id = _user_id;
        this.need_thing = _need_thing;
        this.lettable_thing = _lettable_thing;
    }

    @Override
    public String toString(){
        return "("+user_id+","+need_thing+","+lettable_thing+")";
    }

    public void setImage(Bitmap _need_pic){
        this.need_pic = _need_pic;
    }

    public Bitmap getImage(){
        return need_pic;
    }

    public int getNeed_pic_id(){
        return need_pic_id;
    }

    public void setNeed_pic_id(int _need_pic_id){
        this.need_pic_id = _need_pic_id;
    }

    public String getUser_id(){
        return user_id;
    }

    public void setUser_id(String _user_id){
        this.user_id = _user_id;
    }

    public String getNeed_thing(){
        return need_thing;
    }

    public void setNeed_thing(String _need_thing){
        this.need_thing = _need_thing;
    }

    public String getLettable_thing(){
        return lettable_thing;
    }

    public void setLettable_thing(String _lettable_thing){
        this.lettable_thing = _lettable_thing;
    }

}
