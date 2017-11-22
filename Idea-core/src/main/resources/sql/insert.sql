SET search_path TO root,public;
INSERT  INTO  event VALUES (
'3e6bc91a-c9b6-4aa5-81bd-287024229c1a', 'IDEA0', TIMESTAMP '2016-10-01 00:20:49', TIMESTAMP '2016-11-01 00:20:59', TIMESTAMP '2016-10-01 00:10:49',
TIMESTAMP '2016-10-01 00:30:49', TIMESTAMP '2016-10-02 00:00:49', TIMESTAMP '2016-10-01 01:20:49', 1, 'SSH login attempt',1, '["Anomaly.Traffic"]',
'["https://ftas.cesnet.cz"]', '["cesnak"]', '["correlid"]', '["aggrid"]', '["predid"]', '["rellid"]', 1542, 65528, 26584412, 'description'
);

INSERT  INTO  event VALUES (
'72302776-45dd-4e14-b9eb-a8d653421097', 'IDEA0', TIMESTAMP '2016-09-30 23:58:10', TIMESTAMP '2016-09-20 23:58:10', TIMESTAMP '2016-09-30 23:55:10',
TIMESTAMP '2016-09-30 21:58:10', TIMESTAMP '2016-10-02 00:00:49', TIMESTAMP '2016-09-30 13:58:10', 1, 'login attempt',10, '["Attempt.Login"]',
'["https://cesnet.cz"]', '["cibula"]', '["correlid"]', '["aggrid"]', '["predid"]', '["rellid"]', 3652, 125487, 23588, 'some description'
);

INSERT into node VALUES (
DEFAULT,'["Relay"]','cz.cesnet.ftas', '00:55:55', '["FTAS"]', 'note', '3e6bc91a-c9b6-4aa5-81bd-287024229c1a'
);

INSERT into node VALUES (
DEFAULT,'["Flow", "Statistical"]','cz.cesnet.nemea.hoststats', '00:10:55', '["Nemea", "HostStatsNemea"]', 'note', '72302776-45dd-4e14-b9eb-a8d653421097'
);

INSERT INTO attach VALUES (
DEFAULT, 'handle1','["exe"]', 985220, 'nasty virus', 'trojan', 'UTF-8', 'a-z', '["er5646r4e4164re1", "8fd4rfd648rg6d"]',
'["trustme"]', '["some ref"]', 'more trojans', '["rfr8e484"]', '["www.notrojans.com"]', '72302776-45dd-4e14-b9eb-a8d653421097'
);

INSERT INTO attach VALUES (
DEFAULT, 'handle2','["edoc"]', 46554, 'virus', 'unkonown', 'UTF-8', 'a-z', '["fds658+6", "fd645d4f"]',
'["payday"]', '["some ref"]', 'targeted', '["31535"]', '["www.manager@yourcompany.com"]', '3e6bc91a-c9b6-4aa5-81bd-287024229c1a'
);

INSERT INTO source VALUES (
DEFAULT, '["handle1"]', '["some type"]','["2001:0db8:0000:0000:0000:ff00:0042:8329"]', '["port scanner"]', '["185.125.4.222"]',
'["portscan.com"]', '[22]','["hostname"]', '["tcp", "ssh"]', 'horizontally scanes ports', '["unknown"]', '["mail@mail.com"]',
  'caught scanning all ports', 'true','true','true', '["e5111e"]', '["AMS-IX"]', '["some ref"]','3e6bc91a-c9b6-4aa5-81bd-287024229c1a'
);

INSERT INTO source VALUES (
DEFAULT, '["handle2"]', '["some type"]','["2001:db8:a0b:12f0::1/64"]', '["hash cracker"]', '["195.113.165.128/25"]',
'["crackit.com"]', '[22]','["hostname"]', '["tcp", "ssh"]', 'login asstempt', '["unknown"]', '["mailer@mail.com"]',
  'classic', 'false','false','false', '["461"]', '["AMS-IX"]', '["some ref"]','72302776-45dd-4e14-b9eb-a8d653421097'
);

INSERT INTO target VALUES (
DEFAULT, '["handle1"]', '["some type"]','["2001:0db8:0000:0000:0000:ff00:0042:8329"]', '["port scanner"]', '["195.113.165.128/25"]',
'["portscan.com"]', '[22]','["hostname"]', '["tcp", "ssh"]', 'horizontally scanes ports', '["unknown"]', '["mail@mail.com"]',
  'caught scanning all ports', 'true','true','true', '["e5111e"]', '["AMS-IX"]', '["some ref"]','3e6bc91a-c9b6-4aa5-81bd-287024229c1a'
);

INSERT INTO target VALUES (
DEFAULT, '["handle2"]', '["some type"]','["2001:db8:a0b:12f0::1/64"]', '["hash cracker"]', '["195.113.165.128/25"]',
'["crackit.com"]', '[22]','["hostname"]', '["tcp", "ssh"]', 'login asstempt', '["unknown"]', '["mailer@mail.com"]',
  'classic', 'false','false','false', '["461"]', '["AMS-IX"]', '["some ref"]','72302776-45dd-4e14-b9eb-a8d653421097'
);


