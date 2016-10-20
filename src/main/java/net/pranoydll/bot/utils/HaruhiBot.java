package net.pranoydll.bot.utils;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.util.DiscordException;

public class HaruhiBot {
	
	private ClientBuilder builder = new ClientBuilder();
	private IDiscordClient client;
	
	private EventDispatcher dispatcher;
	
	/*
	 * Returns the HaruhiBot IDiscordClient
	 */
	public IDiscordClient getClient()
	{
	    return client;
	}
	
	private void makeClient(String token) throws DiscordException
	{
		builder.withToken(token);
		client = builder.login();
		
		dispatcher = client.getDispatcher();
		dispatcher.registerListener(new HaruhiEventListener(this));
		
	}
	
	public HaruhiBot(String token) throws DiscordException
	{
		makeClient(token);
	}
	
	public HaruhiBot()
	{
		// null for now
	}
	
	/*
	 * This will make the client if you didn't initially set the token
	 */
	public void setToken(String token) throws DiscordException
	{
		makeClient(token);
	}
}
