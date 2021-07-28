package com.ghozadev.movieapp.utils

import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.data.FilmEntity

object DataDummy {

    fun generateDummyMovies(): ArrayList<FilmEntity> {

        val films = ArrayList<FilmEntity>()

        films.add(FilmEntity(
            "Chaos Walking",
            "7 April 2021",
            "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
            R.drawable.poster_chaos_walking))
        films.add(FilmEntity(
            "Cherry",
            "26 February 2021",
            "Cherry drifts from college dropout to army medic in Iraq - anchored only by his true love, Emily. But after returning from the war with PTSD, his life spirals into drugs and crime as he struggles to find his place in the world.",
            R.drawable.poster_cherry))
        films.add(FilmEntity(
            "Cruella",
            "28 May 2021",
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
            R.drawable.poster_cruella))
        films.add(FilmEntity(
            "Godzilla vs. Kong",
            "24 March 2021",
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
            R.drawable.poster_godzilla_kong))
        films.add(FilmEntity(
            "Mortal Kombat",
            "14 April 2021",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            R.drawable.poster_mortal_kombat
            ))
        films.add(FilmEntity(
            "Nobody",
            "26 March 2021",
            "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
            R.drawable.poster_nobody
            ))
        films.add(FilmEntity(
            "Raya and the Last Dragon",
            "3 March 2021",
            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
            R.drawable.poster_raya
            ))
        films.add(FilmEntity(
            "Soul",
            "25 December 2020",
            "Joe Gardner is a middle school teacher with a love for jazz music. After a successful gig at the Half Note Club, he suddenly gets into an accident that separates his soul from his body and is transported to the You Seminar, a center in which souls develop and gain passions before being transported to a newborn child. Joe must enlist help from the other souls-in-training, like 22, a soul who has spent eons in the You Seminar, in order to get back to Earth.",
            R.drawable.poster_soul
            ))
        films.add(FilmEntity(
            "The Marksman",
            "15 January 2021",
            "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
            R.drawable.poster_the_marksman
            ))
        films.add(FilmEntity(
            "Wrath of Man",
            "5 May 2021",
            "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
            R.drawable.poster_wrath
            ))

        return films
    }

    fun generateDummyTvShows(): ArrayList<FilmEntity> {
        val films = ArrayList<FilmEntity>()

        films.add(FilmEntity(
            "Cobra Kai",
            "",
            "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
            R.drawable.poster_cobra_kai
        ))
        films.add(FilmEntity(
            "Game of Thrones",
            "",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            R.drawable.poster_got
        ))
        films.add(FilmEntity(
            "Legacies",
            "",
            "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
            R.drawable.poster_legacies
        ))
        films.add(FilmEntity(
            "Lucifer",
            "",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            R.drawable.poster_lucifer
        ))
        films.add(FilmEntity(
            "Money Heist",
            "",
            "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
            R.drawable.poster_money_heist
        ))
        films.add(FilmEntity(
            "Riverdale",
            "",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            R.drawable.poster_riverdale
        ))
        films.add(FilmEntity(
            "The Boys",
            "",
            "A group of vigilantes known informally as “The Boys” set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.",
            R.drawable.poster_the_boys
        ))
        films.add(FilmEntity(
            "The Good Doctor",
            "",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
            R.drawable.poster_good_doctor
        ))
        films.add(FilmEntity(
            "The Mandalorian",
            "",
            "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
            R.drawable.poster_mandalorian
        ))
        films.add(FilmEntity(
            "Vikings",
            "",
            "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
            R.drawable.poster_vikings
        ))

        return  films
    }
}