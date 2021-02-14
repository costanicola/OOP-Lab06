package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */
	private final Map<String, Set<U>> friends;

    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */
	public SocialNetworkUserImpl(final String firstName, final String lastName, final String username) {
		this(firstName, lastName, username, -1);
	}
	
    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
	public SocialNetworkUserImpl(final String firstName, final String lastName, final String username, final int age) {
		super(firstName, lastName, username, age);
		this.friends = new HashMap<>();
	}
	
    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
    	Set<U> friendsCircle = this.friends.get(circle);  //friendsCircle ha la lista di utenti interni alla mappa friends
    	if (friendsCircle == null) {  //se è vuota allora
    		friendsCircle = new HashSet<>();  //la istanziamo da 0
    		this.friends.put(circle, friendsCircle);  //e si aggiorna la mappa friends
    	}
    	return friendsCircle.add(user);
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        final Collection<U> userInCircle = this.friends.get(groupName);
        if (userInCircle != null) {
        	return new ArrayList<>(userInCircle);
        }
        return Collections.emptyList(); 
    }

    @Override
    public List<U> getFollowedUsers() {
        final Set<U> followedUsers = new HashSet<>();
        for (final Set<U> group : friends.values()) {
        	followedUsers.addAll(group);
        }
    	return new ArrayList<>(followedUsers);
    	
    }

}
