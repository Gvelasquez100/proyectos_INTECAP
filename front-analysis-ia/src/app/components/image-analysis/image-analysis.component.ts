import { Component, OnInit } from '@angular/core';
import { ImageServiceService } from 'src/app/services/image-service.service';
import {pipeline} from '@xenova/transformers';
import {WaveFile}  from 'wavefile'
import * as wavefile from 'wavefile';
//import {fs} from 'fs';
@Component({
  selector: 'app-image-analysis',
  templateUrl: './image-analysis.component.html',
  styleUrls: ['./image-analysis.component.scss']
})
export class ImageAnalysisComponent implements OnInit{


  speechSynthesis = window.speechSynthesis;
  textToSpeak: string = "Hola, por favor selecciona una imagen para analizarla";
  constructor(private svcImages: ImageServiceService){}

  async start(): Promise<void> {
    /*const EMBED = '';
    const PHARSE = 'Hola, mi nombre es Xenova, soy un asistente virtual, estoy aquí para ayudarte, ¿En qué puedo ayudarte?';

    const synthesizer = await pipeline(
      'text-to-speech',
      'Xenova/speecht5_tts',
      {quantized: false}
    );

    const output = await synthesizer(PHARSE, { speaker_embeddings: EMBED });

    const wav = new  wavefile.WaveFile();
    wav.fromScratch(1, output.sampling_rate, '32f', output.audio);
    fs.writeFileSync('output.wav', wav.toBuffer());*/
  }



  ngOnInit(): void {

  }

  imagenSeleccionada: string | ArrayBuffer | null = null;
  seleccionoImg: boolean = false;
  resultadoAnalisis!: any;
  file!: File;

  onFileSelected(event: any): void {
    const file: File = event.target.files[0];

    if (file) {
      this.seleccionoImg = true;
      const reader = new FileReader();

      reader.onload = (e) => {
        this.imagenSeleccionada = e.target?.result as string | ArrayBuffer | null;
      };

      reader.readAsDataURL(file);
    }
    this.file = file;
    //console.log(file)
  }

  analizarImg(){
    console.log('antes del servicio');
    this.svcImages.predictionImage(this.file).subscribe(data => {
      console.log("llega aqui xD");

      this.resultadoAnalisis = JSON.stringify(data);;
      console.log('RESULTADO : ',this.resultadoAnalisis)
    }, error => {
      console.log(error)
    })
  }
}
