package com.ghozadev.movieapp.utils

import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.data.source.remote.response.MovieResponse
import com.ghozadev.movieapp.data.source.remote.response.TvShowResponse

object DataDummy {

    fun generateDummyMovies(): ArrayList<FilmEntity> {

        val films = ArrayList<FilmEntity>()

        films.add(FilmEntity(
            1,
            "F9",
            "/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
            "2021-05-19",
            "Dominic Toretto and his crew battle the most skilled assassin and high-performance driver they've ever encountered: his forsaken brother.",
            "MOVIE",
            ))
        films.add(FilmEntity(
            2,
            "Jungle Cruise",
            "/9dKCd55IuTT5QRs989m9Qlb7d2B.jpg",
            "2021-07-28",
            "Dr. Lily Houghton enlists the aid of wisecracking skipper Frank Wolff to take her down the Amazon in his dilapidated boat. Together, they search for an ancient tree that holds the power to heal – a discovery that will change the future of medicine.",
            "MOVIE"
            ))
        films.add(FilmEntity(
            3,
            "Black Widow",
            "/qAZ0pzat24kLdO3o8ejmbLxyOac.jpg",
            "2021-07-07",
            "Natasha Romanoff, also known as Black Widow, confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger.",
            "MOVIE",
            ))
        films.add(FilmEntity(
            4,
            "Space Jam: A New Legacy",
            "/5bFK5d3mVTAvBCXi5NPWH0tYjKl.jpg",
            "2021-07-08",
            "When LeBron and his young son Dom are trapped in a digital space by a rogue A.I., LeBron must get them home safe by leading Bugs, Lola Bunny and the whole gang of notoriously undisciplined Looney Tunes to victory over the A.I.'s digitized champions on the court. It's Tunes versus Goons in the highest-stakes challenge of his life.",
            "MOVIE"
            ))
        films.add(FilmEntity(
            5,
            "The Boss Baby: Family Business",
            "/5dExO5G2iaaTxYnLIFKLWofDzyI.jpg",
            "2021-07-01",
            "The Templeton brothers — Tim and his Boss Baby little bro Ted — have become adults and drifted away from each other. But a new boss baby with a cutting-edge approach and a can-do attitude is about to bring them together again … and inspire a new family business.",
            "MOVIE"
            ))
        films.add(FilmEntity(
            6,
            "The Forever Purge",
            "/uHA5COgDzcxjpYSHHulrKVl6ByL.jpg",
            "2021-06-30",
            "All the rules are broken as a sect of lawless marauders decides that the annual Purge does not stop at daybreak and instead should never end as they chase a group of immigrants who they want to punish because of their harsh historical past.",
            "MOVIE"
            ))
        films.add(FilmEntity(
            7,
            "Luca",
            "/jTswp6KyDYKtvC52GbHagrZbGvD.jpg",
            "2021-06-17",
            "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.",
            "MOVIE"
            ))
        films.add(FilmEntity(
            8,
            "The Tomorrow War",
            "/34nDCQZwaEvsy4CFO5hkGRFDCVU.jpg",
            "2021-06-30",
            "The world is stunned when a group of time travelers arrive from the year 2051 to deliver an urgent message: Thirty years in the future, mankind is losing a global war against a deadly alien species. The only hope for survival is for soldiers and civilians from the present to be transported to the future and join the fight. Among those recruited is high school teacher and family man Dan Forester. Determined to save the world for his young daughter, Dan teams up with a brilliant scientist and his estranged father in a desperate quest to rewrite the fate of the planet.",
            "MOVIE"
            ))
        films.add(FilmEntity(
            9,
            "Blood Red Sky",
            "/ky8Fua6PD7FyyOA7JACh3GDETli.jpg",
            "2021-07-23",
            "A woman with a mysterious illness is forced into action when a group of terrorists attempt to hijack a transatlantic overnight flight. In order to protect her son she will have to reveal a dark secret, and unleash the inner monster she has fought to hide.",
            "MOVIE"
            ))
        films.add(FilmEntity(
            10,
            "The Exorcism of Carmen Farias",
            "/uoTPjx07dxTrC1g3dYeaS2WNVGL.jpg",
            "2021-07-05",
            "Carmen, a brave journalist, discovers soon after her mother's death that she has inherited her grandma's house. She decides to move there without knowing it hides dark secrets.",
            "MOVIE"
            ))

        return films
    }

    fun generateDummyTvShows(): ArrayList<FilmEntity> {
        val films = ArrayList<FilmEntity>()

        films.add(FilmEntity(
            11,
            "I Am Not an Animal",
            "/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg",
            "2004-05-10",
            "I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.",
            "TV_SHOW"
        ))
        films.add(FilmEntity(
            12,
            "Run BTS!",
            "/xxv8Ibs8Anni6qrWkAf60rDsPCu.jpg",
            "2015-08-01",
            "Run BTS! is a South Korean show by the boy band BTS. The show is all about BTS doing activities, challenges and lots more.",
            "TV_SHOW"
        ))
        films.add(FilmEntity(
            13,
            "Young Royals",
            "/6CHznbr0BF78ar16zJwTVRYLLOX.jpg",
            "2021-07-01",
            "Prince Wilhelm adjusts to life at his prestigious new boarding school, Hillerska, but following his heart proves more challenging than anticipated.",
            "TV_SHOW"
        ))
        films.add(FilmEntity(
            14,
            "Metal Family",
            "/yovTSLBdNjXIVo8CPaPWFE5NcAw.jpg",
            "2018-09-13",
            "",
            "TV_SHOW"
        ))
        films.add(FilmEntity(
            15,
            "The Rising of the Shield Hero",
            "/6cXf5EDwVhsRv8GlBzUTVnWuk8Z.jpg",
            "2019-01-09",
            "Iwatani Naofumi was summoned into a parallel world along with 3 other people to become the world's Heroes. Each of the heroes respectively equipped with their own legendary equipment when summoned, Naofumi received the Legendary Shield as his weapon. Due to Naofumi's lack of charisma and experience he's labeled as the weakest, only to end up betrayed, falsely accused, and robbed by on the third day of adventure. Shunned by everyone from the king to peasants, Naofumi's thoughts were filled with nothing but vengeance and hatred. Thus, his destiny in a parallel World begins...",
            "TV_SHOW"
        ))
        films.add(FilmEntity(
            16,
            "Given",
            "/pdDCcAq8RNSZNk81PXYoHNUPHjn.jpg",
            "2019-07-12",
            "Tightly clutching his Gibson guitar, Mafuyu Satou steps out of his dark apartment to begin another day of his high school life. While taking a nap in a quiet spot on the gymnasium staircase, he has a chance encounter with fellow student Ritsuka Uenoyama, who berates him for letting his guitar's strings rust and break. Noticing Uenoyama's knowledge of the instrument, Satou pleads for him to fix it and to teach him how to play. Uenoyama eventually agrees and invites him to sit in on a jam session with his two band mates: bassist Haruki Nakayama and drummer Akihiko Kaji.",
            "TV_SHOW"
        ))
        films.add(FilmEntity(
            17,
            "The Promised Neverland",
            "/oBgRCpAbtMpk1v8wfdsIph7lPQE.jpg",
            "2019-01-11",
            "Surrounded by a forest and a gated entrance, the Grace Field House is inhabited by orphans happily living together as one big family, looked after by their \\\"Mama,\\\" Isabella. Although they are required to take tests daily, the children are free to spend their time as they see fit, usually playing outside, as long as they do not venture too far from the orphanage — a rule they are expected to follow no matter what. However, all good times must come to an end, as every few months, a child is adopted and sent to live with their new family... never to be heard from again.\\n\\nHowever, the three oldest siblings have their suspicions about what is actually happening at the orphanage, and they are about to discover the cruel fate that awaits the children living at Grace Field, including the twisted nature of their beloved Mama.",
            "TV_SHOW"
        ))
        films.add(FilmEntity(
            18,
            "Helluva Boss",
            "/mEHUgujxM62HtOyqNgZFENMIqgb.jpg",
            "2020-10-31",
            "Follow Blitzo, a classic demon Imp who sets out to run his own small assassin business with his weapons specialist Moxxie, his bruiser Millie, and his receptionist hellhound Loona. Together they attempt to survive each other while running a startup in Hell.",
            "TV_SHOW"
        ))
        films.add(FilmEntity(
            19,
            "Maid Sama!",
            "/igkn0M1bgMeATz59LShvVxZNdVd.jpg",
            "2010-04-02",
            "Misaki Ayuzawa is the first female student council president at a once all-boys school turned co-ed. She rules the school with strict discipline demeanor. But she has a secret—she works at a maid cafe due to her families circumstances. One day the popular A-student and notorious heart breaker Takumi Usui finds out her secret and makes a deal with her to keep it hush from the school in exchange for spending some time with him.",
            "TV_SHOW"
        ))
        films.add(FilmEntity(
            20,
            "Your Lie in April",
            "/IGbeFv5Ji4W0x530JcSHiQpamY.jpg",
            "2014-10-10",
            "Kousei Arima was a genius pianist until his mother's sudden death took away his ability to play. Each day was dull for Kousei. But, then he meets a violinist named Kaori Miyazono who has an eccentric playing style. Can the heartfelt sounds of the girl's violin lead the boy to play the piano again?",
            "TV_SHOW"
        ))

        return  films
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(MovieResponse(
            1,
            "F9",
            "/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
            "2021-05-19",
            "Dominic Toretto and his crew battle the most skilled assassin and high-performance driver they've ever encountered: his forsaken brother.",
        ))
        movies.add(MovieResponse(
            2,
            "Jungle Cruise",
            "/9dKCd55IuTT5QRs989m9Qlb7d2B.jpg",
            "2021-07-28",
            "Dr. Lily Houghton enlists the aid of wisecracking skipper Frank Wolff to take her down the Amazon in his dilapidated boat. Together, they search for an ancient tree that holds the power to heal – a discovery that will change the future of medicine.",
        ))
        movies.add(MovieResponse(
            3,
            "Black Widow",
            "/qAZ0pzat24kLdO3o8ejmbLxyOac.jpg",
            "2021-07-07",
            "Natasha Romanoff, also known as Black Widow, confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger.",
        ))
        movies.add(MovieResponse(
            4,
            "Space Jam: A New Legacy",
            "/5bFK5d3mVTAvBCXi5NPWH0tYjKl.jpg",
            "2021-07-08",
            "When LeBron and his young son Dom are trapped in a digital space by a rogue A.I., LeBron must get them home safe by leading Bugs, Lola Bunny and the whole gang of notoriously undisciplined Looney Tunes to victory over the A.I.'s digitized champions on the court. It's Tunes versus Goons in the highest-stakes challenge of his life.",
        ))
        movies.add(MovieResponse(
            5,
            "The Boss Baby: Family Business",
            "/5dExO5G2iaaTxYnLIFKLWofDzyI.jpg",
            "2021-07-01",
            "The Templeton brothers — Tim and his Boss Baby little bro Ted — have become adults and drifted away from each other. But a new boss baby with a cutting-edge approach and a can-do attitude is about to bring them together again … and inspire a new family business.",
        ))
        movies.add(MovieResponse(
            6,
            "The Forever Purge",
            "/uHA5COgDzcxjpYSHHulrKVl6ByL.jpg",
            "2021-06-30",
            "All the rules are broken as a sect of lawless marauders decides that the annual Purge does not stop at daybreak and instead should never end as they chase a group of immigrants who they want to punish because of their harsh historical past.",
        ))
        movies.add(MovieResponse(
            7,
            "Luca",
            "/jTswp6KyDYKtvC52GbHagrZbGvD.jpg",
            "2021-06-17",
            "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.",
        ))
        movies.add(MovieResponse(
            8,
            "The Tomorrow War",
            "/34nDCQZwaEvsy4CFO5hkGRFDCVU.jpg",
            "2021-06-30",
            "The world is stunned when a group of time travelers arrive from the year 2051 to deliver an urgent message: Thirty years in the future, mankind is losing a global war against a deadly alien species. The only hope for survival is for soldiers and civilians from the present to be transported to the future and join the fight. Among those recruited is high school teacher and family man Dan Forester. Determined to save the world for his young daughter, Dan teams up with a brilliant scientist and his estranged father in a desperate quest to rewrite the fate of the planet.",
        ))
        movies.add(MovieResponse(
            9,
            "Blood Red Sky",
            "/ky8Fua6PD7FyyOA7JACh3GDETli.jpg",
            "2021-07-23",
            "A woman with a mysterious illness is forced into action when a group of terrorists attempt to hijack a transatlantic overnight flight. In order to protect her son she will have to reveal a dark secret, and unleash the inner monster she has fought to hide.",
        ))
        movies.add(MovieResponse(
            10,
            "The Exorcism of Carmen Farias",
            "/uoTPjx07dxTrC1g3dYeaS2WNVGL.jpg",
            "2021-07-05",
            "Carmen, a brave journalist, discovers soon after her mother's death that she has inherited her grandma's house. She decides to move there without knowing it hides dark secrets.",
        ))

        return movies
    }

    fun generateRemoteDummyTvShow(): List<TvShowResponse> {
        val tvShows = ArrayList<TvShowResponse>()

        tvShows.add(TvShowResponse(
            11,
            "I Am Not an Animal",
            "/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg",
            "2004-05-10",
            "I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.",
        ))
        tvShows.add(TvShowResponse(
            12,
            "Run BTS!",
            "/xxv8Ibs8Anni6qrWkAf60rDsPCu.jpg",
            "2015-08-01",
            "Run BTS! is a South Korean show by the boy band BTS. The show is all about BTS doing activities, challenges and lots more.",
        ))
        tvShows.add(TvShowResponse(
            13,
            "Young Royals",
            "/6CHznbr0BF78ar16zJwTVRYLLOX.jpg",
            "2021-07-01",
            "Prince Wilhelm adjusts to life at his prestigious new boarding school, Hillerska, but following his heart proves more challenging than anticipated.",
        ))
        tvShows.add(TvShowResponse(
            14,
            "Metal Family",
            "/yovTSLBdNjXIVo8CPaPWFE5NcAw.jpg",
            "2018-09-13",
            "",
        ))
        tvShows.add(TvShowResponse(
            15,
            "The Rising of the Shield Hero",
            "/6cXf5EDwVhsRv8GlBzUTVnWuk8Z.jpg",
            "2019-01-09",
            "Iwatani Naofumi was summoned into a parallel world along with 3 other people to become the world's Heroes. Each of the heroes respectively equipped with their own legendary equipment when summoned, Naofumi received the Legendary Shield as his weapon. Due to Naofumi's lack of charisma and experience he's labeled as the weakest, only to end up betrayed, falsely accused, and robbed by on the third day of adventure. Shunned by everyone from the king to peasants, Naofumi's thoughts were filled with nothing but vengeance and hatred. Thus, his destiny in a parallel World begins...",
        ))
        tvShows.add(TvShowResponse(
            16,
            "Given",
            "/pdDCcAq8RNSZNk81PXYoHNUPHjn.jpg",
            "2019-07-12",
            "Tightly clutching his Gibson guitar, Mafuyu Satou steps out of his dark apartment to begin another day of his high school life. While taking a nap in a quiet spot on the gymnasium staircase, he has a chance encounter with fellow student Ritsuka Uenoyama, who berates him for letting his guitar's strings rust and break. Noticing Uenoyama's knowledge of the instrument, Satou pleads for him to fix it and to teach him how to play. Uenoyama eventually agrees and invites him to sit in on a jam session with his two band mates: bassist Haruki Nakayama and drummer Akihiko Kaji.",
        ))
        tvShows.add(TvShowResponse(
            17,
            "The Promised Neverland",
            "/oBgRCpAbtMpk1v8wfdsIph7lPQE.jpg",
            "2019-01-11",
            "Surrounded by a forest and a gated entrance, the Grace Field House is inhabited by orphans happily living together as one big family, looked after by their \\\"Mama,\\\" Isabella. Although they are required to take tests daily, the children are free to spend their time as they see fit, usually playing outside, as long as they do not venture too far from the orphanage — a rule they are expected to follow no matter what. However, all good times must come to an end, as every few months, a child is adopted and sent to live with their new family... never to be heard from again.\\n\\nHowever, the three oldest siblings have their suspicions about what is actually happening at the orphanage, and they are about to discover the cruel fate that awaits the children living at Grace Field, including the twisted nature of their beloved Mama.",
        ))
        tvShows.add(TvShowResponse(
            18,
            "Helluva Boss",
            "/mEHUgujxM62HtOyqNgZFENMIqgb.jpg",
            "2020-10-31",
            "Follow Blitzo, a classic demon Imp who sets out to run his own small assassin business with his weapons specialist Moxxie, his bruiser Millie, and his receptionist hellhound Loona. Together they attempt to survive each other while running a startup in Hell.",
        ))
        tvShows.add(TvShowResponse(
            19,
            "Maid Sama!",
            "/igkn0M1bgMeATz59LShvVxZNdVd.jpg",
            "2010-04-02",
            "Misaki Ayuzawa is the first female student council president at a once all-boys school turned co-ed. She rules the school with strict discipline demeanor. But she has a secret—she works at a maid cafe due to her families circumstances. One day the popular A-student and notorious heart breaker Takumi Usui finds out her secret and makes a deal with her to keep it hush from the school in exchange for spending some time with him.",
        ))
        tvShows.add(TvShowResponse(
            20,
            "Your Lie in April",
            "/IGbeFv5Ji4W0x530JcSHiQpamY.jpg",
            "2014-10-10",
            "Kousei Arima was a genius pianist until his mother's sudden death took away his ability to play. Each day was dull for Kousei. But, then he meets a violinist named Kaori Miyazono who has an eccentric playing style. Can the heartfelt sounds of the girl's violin lead the boy to play the piano again?",
        ))

        return tvShows
    }
}