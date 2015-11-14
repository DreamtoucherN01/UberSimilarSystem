package com.cy.util;

public class TableInfo {
	
	public static String seller = "CREATE TABLE if not exists `seller` "
			+ "(`id` int(16) unsigned NOT NULL,"
			+ "`name` varchar(128) NOT NULL,"
			+ "`mallid` tinyint(1) unsigned NOT NULL,"
			+ "`address` varchar(128) NOT NULL, "
			+ "`password` varchar(128) NOT NULL, "
			+ "PRIMARY KEY  (`id`))"
			+ " ENGINE=MyISAM DEFAULT CHARSET=utf8;";
	
	public static String mall = "CREATE TABLE if not exists `mall` "
			+ "(`mallid` int(16) unsigned NOT NULL,"
			+ "`name` varchar(128) NOT NULL,"
			+ "`carcategory` tinyint(1) unsigned NOT NULL,"
			+ "`caridstr` varchar(128) NOT NULL, "               //using "," to separate
			+ "PRIMARY KEY  (`mallid`))"
			+ " ENGINE=MyISAM DEFAULT CHARSET=utf8;";
	
	public static String car = "CREATE TABLE if not exists `car` "
			+ "(`carid` int(16) unsigned NOT NULL,"
			+ "`name` varchar(128) NOT NULL,"
			+ "`number` tinyint(1) unsigned NOT NULL,"
			+ "PRIMARY KEY  (`carid`))"
			+ " ENGINE=MyISAM DEFAULT CHARSET=utf8;";
	
	public static String buyer = "CREATE TABLE if not exists `buyer` "
			+ "(`id` int(16) unsigned NOT NULL,"
			+ "`name` varchar(128) NOT NULL,"
			+ "`shoppingcartid` tinyint(1) unsigned NOT NULL,"    //using "," to separate
			+ "`info` varchar(128) NOT NULL, "
			+ "`boughtcarid` varchar(128) NOT NULL, "             //using "," to separate
			+ "`password` varchar(128) NOT NULL, "
			+ "PRIMARY KEY  (`id`))"
			+ " ENGINE=MyISAM DEFAULT CHARSET=utf8;";

}
