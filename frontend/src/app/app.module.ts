import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {VgCoreModule} from '@videogular/ngx-videogular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {VgControlsModule} from '@videogular/ngx-videogular/controls';
import {VgOverlayPlayModule} from '@videogular/ngx-videogular/overlay-play';
import {VgBufferingModule} from '@videogular/ngx-videogular/buffering';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AuthConfigModule } from './auth/auth-config.module';
import { UploadVideoComponent } from './upload-video/upload-video.component';
import { VideoPlayerComponent } from './video-player/video-player.component';
import { VideoDetailsComponent } from './video-details/video-details.component';
import { SaveVideoDetailsComponent } from './save-video-details/save-video-details.component';
import { HeaderComponent } from './header/header.component';
import {NgxFileDropModule} from "ngx-file-drop";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatMenuModule} from "@angular/material/menu";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {MatOptionModule} from "@angular/material/core";
import {MatInputModule} from "@angular/material/input";
import {MatChipsModule} from "@angular/material/chips";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import { AuthInterceptor } from 'angular-auth-oidc-client';
import { FlexLayoutModule } from '@angular/flex-layout';


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
    VgBufferingModule,
    NgxFileDropModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatSnackBarModule,
    MatMenuModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    FormsModule,
    MatSelectModule,
    MatOptionModule,
    MatInputModule,
    MatChipsModule

  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
