package pl.dorshop.shop.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

public enum UserType {
    NORMAL_USER, ADMIN, MODERATOR;
}
