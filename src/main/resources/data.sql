--Champions--
INSERT INTO CHAMPIONS(ID, Champion_name) VALUES (0, 'Aatrox');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Ahri');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Akali');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Akshan');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Alistar');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Amumu');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Anivia');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Annie');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Aphelios');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Ashe');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Aurelion sol');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Azir');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Bard');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Bel''veth');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Blitzcrank');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Brand');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Braum');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Caitlyn');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Camille');
INSERT INTO CHAMPIONS(Champion_name) VALUES ('Cassiopeia');
--Items--
    --Mythics--
INSERT INTO ITEMS(ID, Item_name, Item_cost, Is_mythic, Is_boot) VALUES (0, 'Shurelya''s Battlesong', 2500, true, false);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Imperial Mandate', 2500, true, false);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Moonstone Renewer', 2500, true, false);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Evenshroud', 2500, true, false);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Locket of the Iron Solari', 2500, true, false);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Crown of the Shattered Queen', 2800, true, false);
    --Legendaries--
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Mejai''s Soulstealer', 1600, false, false);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Ardent Censer', 2300, false, false);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Staff of Flowing Water', 2300, false, false);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Chemtech Putrifier', 2300, false, false);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Mikael''s Blessing', 2300, false, false);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Redemption', 2300, false, false);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Umbral Glaive', 2300, false, false);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Knight''s Vow', 2300, false, false);

    --Boots--
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Boots of Swiftness', 900, false, true);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Sorcerer''s Shoes', 1100, false, true);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Mobility Boots', 1000, false, true);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Ionian Boots of Lucidity', 950, false, true);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Mercury''s Treads', 1100, false, true);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Plated Steelcaps', 1100, false, true);
INSERT INTO ITEMS(Item_name, Item_cost, Is_mythic, Is_boot) VALUES ('Berserker''s Greaves', 1100, false, true);

--Runes--
    --Precision
INSERT INTO RUNES(Id, Rune_name, Rune_family, Rune_tier) VALUES (0, 'Press the Attack', 'Precision', 0);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Lethal Tempo', 'Precision', 0);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Fleet Footwork', 'Precision', 0);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Conqueror', 'Precision', 0);

INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Overheal', 'Precision', 1);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Triumph', 'Precision', 1);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Presence of Mind', 'Precision', 1);

INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Legend: Alacrity', 'Precision', 2);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Legend: Tenacity', 'Precision', 2);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Legend: Bloodline', 'Precision', 2);

INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Coup de Grace', 'Precision', 3);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Cut Down', 'Precision', 3);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Last Stand', 'Precision', 3);

    --Domination--
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Electrocute', 'Domination', 0);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Predator', 'Domination', 0);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Dark Harvest', 'Domination', 0);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Hail of Blades', 'Domination', 0);

INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Cheap Shot', 'Domination', 1);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Taste of Blood', 'Domination', 1);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Sudden Impact', 'Domination', 1);

INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Zombie Ward', 'Domination', 2);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Ghost Poro', 'Domination', 2);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Eyeball Collection', 'Domination', 2);

INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Treasure Hunter', 'Domination', 3);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Ingenious Hunter', 'Domination', 3);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Relentless Hunter', 'Domination', 3);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Ultimate Hunter', 'Domination', 3);

    --Sorcery--
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Summon Aery', 'Sorcery', 0);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Arcane Comet', 'Sorcery', 0);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Phase Rush', 'Sorcery', 0);

INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Nullifying Orb', 'Sorcery', 1);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Manaflow Band', 'Sorcery', 1);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Nimbus Cloak', 'Sorcery', 1);

INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Transcendence', 'Sorcery', 2);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Celerity', 'Sorcery', 2);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Absolute Focus', 'Sorcery', 2);

INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Scorch', 'Sorcery', 3);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Waterwalking', 'Sorcery', 3);
INSERT INTO RUNES(Rune_name, Rune_family, Rune_tier) VALUES ('Gathering Storm', 'Sorcery', 3);

    --Resolve--


--Summoners--