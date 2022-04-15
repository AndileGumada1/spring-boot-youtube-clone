import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {VgCoreModule} from '@videogular/ngx-videogular/core';
import {VgControlsModule} from '@videogular/ngx-videogular/controls';
import {VgOverlayPlayModule} from '@videogular/ngx-videogular/overlay-play';
import {VgBufferingModule} from '@videogular/ngx-videogular/buffering';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AuthConfigModule } from './auth/auth-config.module';
import { UploadVideoComponent } from './upload-video/upload-video.component';
import { VideoPlayerComponent } from './video-player/video-player.component';
import { VideoDetailsComponent } from './video-details/video-details.component';
import { SaveVideoDetailsComponent } from './save-video-details/save-video-details.component';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    UploadVideoComponent,
    VideoPlayerComponent,
    VideoDetailsComponent,
    SaveVideoDetailsComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AuthConfigModule,
    VgCoreModule,
    VgControlsModule,
    VgOverlayPlayModule,
    VgBufferingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
