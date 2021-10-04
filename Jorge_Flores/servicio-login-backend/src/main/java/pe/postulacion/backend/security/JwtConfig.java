package pe.postulacion.backend.security;

public class JwtConfig {
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpgIBAAKCAQEAtetGC8klkjV/sjEvsN0k2P/sBel0DxdITPfsD09wyJz5xxK7\r\n"
			+ "PAj7211o6hbqtuNdtMVJgkLmPK+HyvSEYhdmvfke1lFeX46LDKvmXBDmQOAc6kgZ\r\n"
			+ "JIUoUK6ouWuudrj7T6l2Msn++WwYmX8b1FxZzmJq7nkYUJypkeJCEH+g07JffxY7\r\n"
			+ "oo69AfJ4/LIXondkdpmnKSmKVS0CCvaQb/kbWJ9my4FfCZP5IfATpq4cZB25axJ6\r\n"
			+ "b/MPSPXBb7/LWfhhvk3dLJe4fuNMsNBGjn/iIPRP8icIIb8tfR0p1W53ym3GOYxE\r\n"
			+ "HEILYg+4DS7SmZxhJ+1yHf9Lffq8z4GLKUyVIQIDAQABAoIBAQCksIPPM6AhxvD9\r\n"
			+ "nm2wTeOH19gSWhBJgShhFajNC3vtAb9WK2z5oqBvLRdHpMuEGj3A40Hy/SF2Gupy\r\n"
			+ "H/6g1tKadScnmq43D9Jt/EklW983KCzFI9QvLaUbtaLlich9jmVk7uMkg52iq+tx\r\n"
			+ "OpM1Iw3iO1LW5SXQBKO2gACS8xfjzPbH0ocENroR7zbyBB5TTVJS6/N5qm4WDybx\r\n"
			+ "Tk1c7NZgwazX/cLz0FaFSWAxRAJQd17xns+P/6cDhSz1ZtRrKuEszSSaYZM9psNy\r\n"
			+ "KGdt/O2Q+bO3kPYolMiD7wQwuAAi5Zu5o3qfq2eaxT+sLIo/hZ+n6fI8vmZ0arGr\r\n"
			+ "UfCo3rOJAoGBANpXPF0QfNDLi+Bg5D06yvHssdVRP6fesItMIbRlGYcSyKu424+e\r\n"
			+ "L++u8IBQX2a58ZITCKZNecSspRkiHFzr6KBNlG6t4uvwlsWpsgk9octF2u84fyuY\r\n"
			+ "hxqJ8VaWz6WXq+k7JuyjGrH83/D3H9LmIk//gJd9gNLJSfgVivgdYxwfAoGBANVL\r\n"
			+ "2Tf0LGxcVNUY9L7nlaQHaik0GLFz4iBBsgthNDjnP5m/Ezjb5jJ8LBKP4BQmNV9s\r\n"
			+ "jV/qPv5T4GZ2/iovsGnKNE3IJOrvjAdWvIKM3kfzXEFIIQysqDq/OPEYi5uRgzET\r\n"
			+ "fYMpFCAX4wGHatn9MTf57hvmJD4qxAVc4FX0Eia/AoGBAKpIbuOGAFI27RhJeLfo\r\n"
			+ "Km8TUn4zp5mcq8N31LGER6x4kdibi2Eu1ePwY9Eu3biYPDbYcV6B/f3NR9WaLNSr\r\n"
			+ "h/m9h43qP5gTQwNVnWxnjM+j42O+hC/T/UpNWtNVOwzChWiYoXrcme1GcsDTexZY\r\n"
			+ "NVp+wiNj1hyOsAmzg3aONMWxAoGBAMfHq0VFZvZ35N1T6qmEsBxa9YxyR06ug/ZC\r\n"
			+ "kkkmWouRzXhsB80R6qMOuxkHuZIl14fxXNmhxi7g0SYn/hf1Yv8zbZoNBMcoZ7fX\r\n"
			+ "/ekpmGk8AAUFUi9U6J1dzi/EFb84o/CrmLvpFfiZZv5foC1dgWQ0rFllTj0MQV3k\r\n"
			+ "iBr56KZxAoGBANEQdWW1/gDZ+J9A6Nx8+uDhz8t6wWU2zUxjpJ9jknG/z4zZpuzP\r\n"
			+ "biQA58FHp1PuZXAJFCw/emXqX4CMn9bwFfqkQ8otc24woYZPYYkTqFGG55u52TFT\r\n"
			+ "tTsW7Pb7AHw8/BG6juWYMKUHJug1uaOr2qPiAFBmrSKkaRvieRk9m3pT\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtetGC8klkjV/sjEvsN0k\r\n"
			+ "2P/sBel0DxdITPfsD09wyJz5xxK7PAj7211o6hbqtuNdtMVJgkLmPK+HyvSEYhdm\r\n"
			+ "vfke1lFeX46LDKvmXBDmQOAc6kgZJIUoUK6ouWuudrj7T6l2Msn++WwYmX8b1FxZ\r\n"
			+ "zmJq7nkYUJypkeJCEH+g07JffxY7oo69AfJ4/LIXondkdpmnKSmKVS0CCvaQb/kb\r\n"
			+ "WJ9my4FfCZP5IfATpq4cZB25axJ6b/MPSPXBb7/LWfhhvk3dLJe4fuNMsNBGjn/i\r\n"
			+ "IPRP8icIIb8tfR0p1W53ym3GOYxEHEILYg+4DS7SmZxhJ+1yHf9Lffq8z4GLKUyV\r\n"
			+ "IQIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

}
