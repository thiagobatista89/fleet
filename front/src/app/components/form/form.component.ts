import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../table/table.component';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})

export class FormComponent implements OnInit {
  @Input() btnText!: string;
  momentForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private userService: UserService) {}

  ngOnInit(): void {
    this.momentForm = this.formBuilder.group({
      id: [''],
      name: [''],
      nif: ['']
    });
  }

  reset() {
    this.momentForm.reset();
  }

  submit() {
    if (this.momentForm.valid) {
      const user: User = this.momentForm.value;
  
      this.userService.post(user).subscribe(
        (response: any) => {
          console.log('Usuário atualizado com sucesso', response);
          window.location.reload();
        },
        (error: any) => {
          console.error('Erro ao atualizar usuário', error);
        }
      );

 
    }
  }
}
