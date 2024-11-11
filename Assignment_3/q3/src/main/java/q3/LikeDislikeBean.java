package q3;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LikeDislikeBean {
    private int likeCount = 0;
    private int dislikeCount = 0;

    // Getter for like count
    public int getLikeCount() {
        return likeCount;
    }

    // Getter for dislike count
    public int getDislikeCount() {
        return dislikeCount;
    }

    // Increment like count
    public void like() {
        likeCount++;
    }

    // Increment dislike count
    public void dislike() {
        dislikeCount++;
    }
}
