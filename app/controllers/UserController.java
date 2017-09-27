package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import models.UserRepository;
import play.mvc.Result;
import play.libs.Json;
import play.mvc.Controller;

import javax.inject.Inject;

public class UserController extends Controller {

    private UserRepository userRepository;

    @Inject
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result add() {
        JsonNode json = request().body().asJson();
        final User user = Json.fromJson(json, User.class);
        userRepository.add(user);
        return created(Json.toJson(user));
    }

}
