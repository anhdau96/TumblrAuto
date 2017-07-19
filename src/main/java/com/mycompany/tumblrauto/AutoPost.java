/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tumblrauto;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.LinkPost;
import com.tumblr.jumblr.types.Photo;
import com.tumblr.jumblr.types.PhotoPost;
import dbcontroler.TweetLinkController;
import filecontroller.FileControler;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LinkPin;

/**
 *
 * @author SaiBack
 */
public class AutoPost {

    public static void main(String[] args) {
        Random r = new Random();
        // Create a new client
        TweetLinkController controller = new TweetLinkController();
        while (true) {
            List<LinkPin> linkTweets = controller.getLinkTweet();
            for (LinkPin linkTweet : linkTweets) {
                int nextInt = r.nextInt(2);
                if (nextInt == 0) {
                    try {
                        postImage(linkTweet, controller);
                    } catch (IllegalAccessException | InstantiationException | IOException | InterruptedException ex) {
                        postLink(linkTweet, controller);
                        Logger.getLogger(AutoPost.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    postLink(linkTweet, controller);
                }
            }
        }

    }

    public static void postImage(LinkPin linkTweet, TweetLinkController controller) throws IllegalAccessException, InstantiationException, IOException, InterruptedException {
        JumblrClient client = new JumblrClient(
                "uRqhE90jMQvHh2dQMxYIgQYBL8RQa5F4YvAedxM2yYTZBUVtqa",
                "fTfj025egolcH94I3OSmRwBzER3wyoqTnFoRTFxdJaqEsg3kgm"
        );
        client.setToken(
                "LBaICi2lfuFzIcpklZlim1vkDntJp5UJNUKqjTy5VDwngrWscx",
                "v7Sm8blbky450DzLLbJajPE7mvo5VIcnQsKgZga3s14WNZshnZ"
        );
        PhotoPost post = client.newPost("tshirts-studio", PhotoPost.class);
//        FileControler.getImg(linkTweet.getImg());
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
        System.out.println(linkTweet.getTitle());
        Thread.sleep(((long) (Math.random() * (600000 - 500000)) + 500000));
    }

    public static void postLink(LinkPin linkTweet, TweetLinkController controller) {
        try {
            JumblrClient client = new JumblrClient(
                    "uRqhE90jMQvHh2dQMxYIgQYBL8RQa5F4YvAedxM2yYTZBUVtqa",
                    "fTfj025egolcH94I3OSmRwBzER3wyoqTnFoRTFxdJaqEsg3kgm"
            );
            client.setToken(
                    "LBaICi2lfuFzIcpklZlim1vkDntJp5UJNUKqjTy5VDwngrWscx",
                    "v7Sm8blbky450DzLLbJajPE7mvo5VIcnQsKgZga3s14WNZshnZ"
            );
            LinkPost post = client.newPost("tshirts-studio", LinkPost.class);
            post.setTitle(linkTweet.getTitle());
            post.setDescription(linkTweet.getDes());
            post.setLinkUrl(linkTweet.getLink());
            post.save();
            controller.updateLinkTweet(linkTweet.getId());
            System.out.println(linkTweet.getTitle());
            Thread.sleep(((long) (Math.random() * (300000 - 200000)) + 200000));
        } catch (IllegalAccessException | InstantiationException | InterruptedException ex) {
            Logger.getLogger(AutoPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
