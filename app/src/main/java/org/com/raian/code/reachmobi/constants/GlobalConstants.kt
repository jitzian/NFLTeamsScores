package org.com.raian.code.reachmobi.constants

class GlobalConstants {

    companion object {
        const val nflBaseUrl = "https://armchairanalysis.com/api/1.0/"

        //Constants for saving RoomDB
        const val dataBaseName = "teams_database.db"
        const val dataBaseVersion = 2

        //TODO: Make this a list of pairs<>
        val mapOfTeams = mapOf(
            "ARI" to "nfl_arizona_cardinals",//ARI
            "ATL" to "nfl_atlanta_falcons",//ATL
            "BAL" to "nfl_baltimore_ravens",//BAL
            "BUF" to "nfl_buffalo_bills",//BUF
            "CAR" to "nfl_carolina_panthers",//CAR
            "CHI" to "nfl_chicago_bears",//CHI
            "CIN" to "nfl_cincinnati_bengals",//CIN
            "CLE" to "nfl_cleveland_browns",//CLE
            "DAL" to "nfl_dallas_cowboys",//DAL
            "DEN" to "nfl_denver_broncos",//DEN
            "DET" to "nfl_detroit_lions",//DET
            "GB" to "nfl_green_bay_packers",//GB
            "HOU" to "nfl_houston_texans",//HOU
            "IND" to "nfl_indianapolis_colts",//IND
            "JAX" to "nfl_jacksonville_jaguars",//JAX
            "KAC" to "nfl_kansas_city_chiefs",//KAC
            "LAC" to "nfl_los_angeles_chargers",//LAC
            "LA" to "nfl_los_angeles_rams",//LA
            "MIA" to "nfl_miami_dolphins",//MIA
            "MIN" to "nfl_minnesota_vikings",//MIN
            "NE" to "nfl_new_england_patriots",//NE
            "NO" to "nfl_new_orleans_saints",//NO
            "NYG" to "nfl_new_york_giants",//NYG
            "NYJ" to "nfl_new_york_jets",//NYJ
            "OAK" to "nfl_oakland_raiders",//OAK
            "PHI" to "nfl_philadelphia_eagles",//PHI
            "PIT" to "nfl_pittsburgh_steelers",//PIT
            "SF" to "nfl_san_francisco_49ers",//SF
            "SEA" to "nfl_seattle_seahawks",//SEA
            "TB" to "nfl_tampa_bay_buccaneers",//TB
            "TEN" to "nfl_tennessee_titans",//TEN
            "WAS" to "nfl_washington_redskins"//WAS
        )

        val mapOfCityImages = mapOf(
            "ARI" to "https://frntofficesport.com/wp-content/uploads/2018/09/Untitled-design-6.png",//ARI
            "ATL" to "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fkeithflamer%2Ffiles%2F2017%2F08%2FMercedes-Benz-Stadium.jpg",//ATL
            "BAL" to "https://miro.medium.com/max/1200/1*aT9zd6FBXigq0cRF2Dw4rw.jpeg",//BAL
            "BUF" to "https://s3.amazonaws.com/bncore/wp-content/uploads/2017/04/McCoy-Sports-best-of-2015-A10.jpg",//BUF
            "CAR" to "https://cdn-s3.si.com/s3fs-public/images/2016-0103-Carolina-Panthers.jpg",//CAR
            "CHI" to "https://cdn.vox-cdn.com/thumbor/ybnbgoJTUKvg7KrpxMTP0o5AwRQ=/0x0:4713x3142/1200x800/filters:focal(1928x787:2682x1541)/cdn.vox-cdn.com/uploads/chorus_image/image/60756493/usa_today_10472036.0.jpg",//CHI
            "CIN" to "http://www.ourlads.com/images/blogs/Cincinnati-Bengals.jpg",//CIN
            "CLE" to "https://ewscripps.brightspotcdn.com/dims4/default/2e10daa/2147483647/strip/true/crop/640x360+0+60/resize/1280x720!/quality/90/?url=https%3A%2F%2Fsharing.news5cleveland.com%2Fsharewews%2Fphoto%2F2017%2F05%2F24%2Fbrowns_1495672865581_60143096_ver1.0_640_480.jpg",//CLE
            "DAL" to "https://webgameapp.com/wallpapers/dallas-cowboys-4k-wallpaper/download/2560x1440.jpg",//DAL
            "DEN" to "https://imagesvc.timeincapp.com/v3/fan/image?url=https%3A%2F%2Fpredominantlyorange.com%2Fwp-content%2Fuploads%2Fgetty-images%2F2018%2F08%2F1172273877.jpeg&c=sc&w=736&h=485",//DEN
            "DET" to "https://static.clubs.nfl.com/image/private/t_editorial_landscape_12_desktop/lions/mckohp4vcqmjrcwddja0.jpg",//DET
            "GB" to "https://thespun.com/wp-content/uploads/2019/04/GettyImages-1062128062-775x465.jpg",//GB
            "HOU" to "https://thespun.com/wp-content/uploads/2019/04/GettyImages-1072751472-775x465.jpg",//HOU
            "IND" to "https://horseshoeheroes.com/wp-content/blogs.dir/47/files/2016/02/nfl-indianapolis-colts-carolina-panthers-1.jpg",//IND
            "JAX" to "https://cdn.vox-cdn.com/thumbor/PXcrv6Nrjd-QZDbKBUXuVkDcUmM=/0x0:3000x1902/1200x800/filters:focal(1260x711:1740x1191)/cdn.vox-cdn.com/uploads/chorus_image/image/56144455/630499384.0.jpg",//JAX
            "KAC" to "http://static.nfl.com/static/content/public/photo/2015/07/09/0ap3000000500837.jpg",//KAC
            "LAC" to "http://kfmb.upickem.net/EngineContent/KFMB/140808/PHOTO-140808-70021349P.jpg",//LAC
            "LA" to "http://www1.pictures.zimbio.com/gi/Robert+Quinn+Washington+Redskins+v+St+Louis+3ztovTyPHEKl.jpg",//LA
            "MIA" to "https://clutchpoints.com/wp-content/uploads/2019/02/Miami-Dolphins.jpg",//MIA
            "MIN" to "https://imageproxy.themaven.net/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fmaven-user-photos%2Fprofootballguru%2Fpfg-vibe%2F7NUcj5kXoEWIkkN2Zusy7g%2F25NQTYv7VkyQwOXnDNy6lA",//MIN
            "NE" to "https://imagesvc.timeincapp.com/v3/mm/image?url=https%3A%2F%2Fcdn-s3.si.com%2Fs3fs-public%2Fstyles%2Fmarquee_large_2x%2Fpublic%2F2016%2F04%2F28%2Fpatriots-picks-nfl-draft.jpg%3Fitok%3Dzbst7PiR&w=1000&q=70",//NE
            "NO" to "https://www.ocregister.com/wp-content/uploads/2018/11/Rams-Saints-Football_27552420_5762383.jpg?w=620",//NO
            "NYG" to "https://www.bigblueinteractive.com/wp-content/uploads/2019/09/New-York-Giants-Helmets-September-22-2019.jpg",//NYG
            "NYJ" to "https://www.washingtonpost.com/resizer/4M9ocJ6_sVTtSO3lPygWFSFXwsI=/767x0/smart/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/VXQYCTHUO4I6TMWSD434TWBNXM.jpg",//NYJ
            "OAK" to "https://res-5.cloudinary.com/ybmedia/image/upload/c_crop,h_665,w_1185,x_354,y_62/c_fill,f_auto,h_495,q_auto,w_880/v1/m/0/3/03a9ce1a4650071c5b2868dfa111bc908b9bb70e/josh.jpg",//OAK
            "PHI" to "https://www.nbcsports.com/philadelphia/sites/csnphilly/files/styles/article_hero_image/public/2018/12/17/defense-2.jpg?itok=AFprdoHC",//PHI
            "PIT" to "https://specials-images.forbesimg.com/imageserve/221c36874c8c44869532c9ccd8fb611f/960x0.jpg?fit=scale",//PIT
            "SF" to "https://i0.wp.com/www.profootballnetwork.com/wp-content/uploads/2019/04/san-francisco-49ers-george-kittle.jpg?fit=3281%2C2214&ssl=1",//SF
            "SEA" to "https://sports.mynorthwest.com/wp-content/uploads/2019/01/Russell-Wilson-Cowboys-620x370.jpg",//SEA
            "TB" to "https://images2.minutemediacdn.com/image/upload/c_fill,w_688,ar_16:9,f_auto,q_auto,g_auto/shape/cover/sport/Cleveland-Browns-v-Tampa-Bay-Buccaneers-0860ab07407e4a11b4f87d440bfe20c9.jpg",//TB
            "TEN" to "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmm6aDggegar66bnkNwBaS82phj5UVnGgPk7UU90_t8WHAdsqj&s",//TEN
            "WAS" to "https://cdn.vox-cdn.com/thumbor/0bptdfV2iQI2Ey8vudcc-czXBSE=/0x0:4192x3220/1200x800/filters:focal(1872x90:2542x760)/cdn.vox-cdn.com/uploads/chorus_image/image/61014753/usa_today_11124139.0.jpg"//WAS
        )
    }

}