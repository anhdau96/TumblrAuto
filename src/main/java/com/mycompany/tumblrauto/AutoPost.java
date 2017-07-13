/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tumblrauto;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Photo;
import com.tumblr.jumblr.types.PhotoPost;
import dbcontroler.TweetLinkController;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LinkPin;

/**
 *
 * @author SaiBack
 */
public class AutoPost {

    public static void main(String[] args) {
        try {
            // Create a new client
            JumblrClient client = new JumblrClient("uRqhE90jMQvHh2dQMxYIgQYBL8RQa5F4YvAedxM2yYTZBUVtqa",
                    "fTfj025egolcH94I3OSmRwBzER3wyoqTnFoRTFxdJaqEsg3kgm");
            client.setToken("0rcVT1mixBbOLr6qFtjQW7MEJN5t8S9yN3CBochRUSoSvpwj48",
                    "6WL5pBE9c0Msn7bVjskaqbvKjFxU8j7Q2uJ59zBhEBujQ35a9v");
            TweetLinkController controller = new TweetLinkController();
            while (true) {
                List<LinkPin> linkTweets = controller.getLinkTweet();
                for (LinkPin linkTweet : linkTweets) {
                    PhotoPost post = client.newPost("tshirts-studio", PhotoPost.class);
                    post.setPhoto(new Photo(linkTweet.getImg()));
                    String caption = "Where can you buy lovely t-shirt? \n"
                            + "\n"
                            + " New Design - Cheap - Sport - Dynamic - Youthful \n"
                            + "\n"
                            + " Welcome to T-shirts Shop ^^ \n"
                            + "\n"
                            + linkTweet.getLink();
                    post.setCaption(caption);
                    post.save();
                    controller.updateLinkTweet(linkTweet.getId());
                    System.out.println(linkTweet.getNote());
                    Thread.sleep(((long) (Math.random() * (300000 - 200000)) + 200000));
                }
            }
        } catch (IllegalAccessException | InstantiationException | IOException | InterruptedException ex) {
            Logger.getLogger(AutoPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
