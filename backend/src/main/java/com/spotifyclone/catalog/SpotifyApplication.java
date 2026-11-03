package com.spotifyclone.catalog;
import com.spotifyclone.catalog.model.*; import com.spotifyclone.catalog.repository.*; import org.springframework.boot.*; import org.springframework.boot.autoconfigure.SpringBootApplication; import org.springframework.context.annotation.Bean;
@SpringBootApplication public class SpotifyApplication {
 public static void main(String[] args){SpringApplication.run(SpotifyApplication.class,args);}
 @Bean CommandLineRunner seed(ArtistRepository artists,AlbumRepository albums,SongRepository songs,AppUserRepository users){return args->{
 users.findByEmailIgnoreCase("admin").orElseGet(()->users.save(new AppUser("admin","admin")));
 String[] names={"The Midnight Signals","Northern Lights","Electric Avenue","Blue Echo","Static Dreams"};
 String[] bios={"Indie rock nocturno nacido en la ciudad.","Melodías luminosas inspiradas en el norte.","Pop electrónico para recorrer la ciudad.","Canciones tranquilas de guitarra y mar.","Rock alternativo de sonido enérgico."};
 String[] titles={"Midnight Road","Aurora Lines","Neon Boulevard","Tidal Memory","After the Static"};
 String[][] tracks={{"Midnight Road","Last Train Home"},{"Northern Sky","Dancing Snow"},{"Electric Avenue","City Lights"},{"Blue Echo","Faraway Coast"},{"Static Dreams","Signal Fire"}};
 for(int i=0;i<names.length;i++){Artist a=artists.save(new Artist(names[i],bios[i],"https://placehold.co/400x400/183b2a/ffffff?text=Artist+"+(i+1)));
 for(int j=0;j<2;j++){Album al=albums.save(new Album(titles[i]+(j==1?" II":""),String.valueOf(2007+j),"https://placehold.co/500x500/183b2a/ffffff?text=Album+"+(i+1),a));
 for(int k=0;k<2;k++){String audio="https://www.soundhelix.com/examples/mp3/SoundHelix-Song-"+(i*4+j*2+k+1)+".mp3";songs.save(new Song(tracks[i][j]+(j==1?" (Live)":""),180+k*24,al,a,audio));}
 }}
 };}
}
